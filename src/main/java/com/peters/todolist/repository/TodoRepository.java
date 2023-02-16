package com.peters.todolist.repository;

import com.peters.todolist.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Note, Long> {
}
