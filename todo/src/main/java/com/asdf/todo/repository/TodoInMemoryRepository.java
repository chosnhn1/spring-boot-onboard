package com.asdf.todo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.asdf.todo.model.Todo;

@Repository
public class TodoInMemoryRepository {

    private final Map<Long, Todo> todoMap = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Todo> findAll() {
        return new ArrayList<>(todoMap.values());
    }

    public Todo findById(Long id) {
        return todoMap.get(id);
    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {

            // 어 이걸 직접 한다고? 안 해도 되지 않나... (추후에 수정)
            todo.setId(counter.incrementAndGet());
        }
        todoMap.put(todo.getId(), todo);
        return todo;
    }

    public void deleteById(Long id) {
        todoMap.remove(id);
    }
}
