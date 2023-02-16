package com.peters.todolist.service;

import com.peters.todolist.model.Note;

import java.util.List;

public interface TodoService {
    List<Note> getAllRecord();
    void saveRecord(Note note);
    Note findRecordById(long id);
    void deleteRecord(long id);
}
