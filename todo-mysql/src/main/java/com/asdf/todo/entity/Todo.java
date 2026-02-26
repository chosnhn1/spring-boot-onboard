package com.asdf.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, name = "title")
    private String title;

    // 필드명과 테이블 컬럼명이 같으면 @Column 애너테이션 생략 가능
    @Column(name = "description")
    private String description;

    @Column(nullable = false, name = "completed")
    private boolean completed;

    @Column(
            nullable = false,
            name = "created_at",
            insertable = false,
            updatable = false,
            // 여기에 SQL문으로 일부 조건 직접 작성하는 것에 주의
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
