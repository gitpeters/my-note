package com.peters.todolist.controller;

import com.peters.todolist.model.Note;
import com.peters.todolist.service.TodoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    private TodoServiceImp service;

    @GetMapping("/")
    public String getAllNotes(Model model){
        model.addAttribute("noteList", service.getAllRecord());
        return "index";
    }

    @GetMapping("/newNote")
    public String newNote(Model model){
        Note note = new Note();
        model.addAttribute("note", note);
        return "newnote";
    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute Note note, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }else{

            service.saveRecord(note);
            System.out.println("Record saved successfully");
        }

        return "redirect:/";
    }

    @GetMapping("updateNote/{id}")
    public String updateNote(@PathVariable("id") long id, Model model){
        Note note = service.findRecordById(id);
        model.addAttribute("note", note);
        return "updatenote";
    }
    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") long id){
        this.service.deleteRecord(id);
        return "redirect:/";
    }
}
