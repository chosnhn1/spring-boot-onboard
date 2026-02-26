package com.asdf.todo.service;

import com.asdf.todo.model.Todo;
import com.asdf.todo.repository.TodoInMemoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    // 서비스에서 할 일: 구체적인 CRUD의 작동방식 (비즈니스 로직) 구현
    // 다만 이 정도는 거의 repo를 받아서 처리하면 문제없는 수준
    private final TodoInMemoryRepository repo;

    @Autowired
    public TodoService(TodoInMemoryRepository todoRepository) {
        this.repo = todoRepository;
    }

    public List<Todo> findAll() {
        return repo.findAll();
    }

    public Todo findById(Long id) {
        return repo.findById(id);
    }

    public Todo save(Todo todo) {
        return repo.save(todo);
    }

    public Todo update(Long id, Todo todo) {
        todo.setId(id);
        return repo.save(todo);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
