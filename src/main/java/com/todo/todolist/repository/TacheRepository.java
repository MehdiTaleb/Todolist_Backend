package com.todo.todolist.repository;

import com.todo.todolist.entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}