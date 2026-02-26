package com.asdf.todo.service;

import com.asdf.todo.dto.TodoRequestDto;
import com.asdf.todo.dto.TodoResponseDto;
import com.asdf.todo.entity.Todo;
import com.asdf.todo.repository.TodoRepository;
import com.asdf.todo.util.EntityDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

    // get rid of in-memory repo
    // private final TodoInMemoryRepository repo;
    private final TodoRepository repo;

    @Autowired
    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    // @Transactional: JPA 연동 시의 무결성 보장 (대상 연산 = 1 transaction)
    // readOnly: 쓰기 잠금 방지
    @Transactional(readOnly = true)
    public List<TodoResponseDto> findAll() {
        // Todo Entity 대신 DTO와 상호작용한다
        return repo.findAll().stream()
                .map(EntityDtoMapper::toDto)
                .collect(Collectors.toList()); // Stream을 이용한 함수형 문법 복기하기
    }

    @Transactional(readOnly = true)
    public TodoResponseDto findById(Long id) {

        return repo.findById(id).map(EntityDtoMapper::toDto).orElse(null);
    }

    @Transactional
    public TodoResponseDto save(TodoRequestDto todoRequestDto) {
        Todo todo = EntityDtoMapper.toEntity(todoRequestDto);
        Todo savedTodo = repo.save(todo);
        return EntityDtoMapper.toDto(savedTodo);
    }

    @Transactional
    public TodoResponseDto update(Long id, TodoRequestDto todoRequestDto) {
        Todo todo = EntityDtoMapper.toEntity(todoRequestDto);
        todo.setId(id);
        Todo updatedTodo = repo.save(todo);
        return EntityDtoMapper.toDto(updatedTodo);
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
