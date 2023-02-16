package com.peters.todolist.service;

import com.peters.todolist.model.Note;
import com.peters.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoService{
    @Autowired
    private final TodoRepository repository;

    public TodoServiceImp(TodoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Note> getAllRecord() {
        return repository.findAll();
    }

    @Override
    public void saveRecord(Note note) {
        this.repository.save(note);
    }

    @Override
    public Note findRecordById(long id) {
        Note note = null;
        Optional<Note> nt = repository.findById(id);
        if(nt.isPresent()){
            note = nt.get();
        }
        return note;
    }

    @Override
    public void deleteRecord(long id) {
        this.repository.deleteById(id);
    }
}
