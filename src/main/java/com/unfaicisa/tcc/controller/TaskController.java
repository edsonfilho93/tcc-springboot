package com.unfaicisa.tcc.controller;

import com.unfaicisa.tcc.entity.Task;
import com.unfaicisa.tcc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(service.getTasks());
    }

    @PostMapping
    public ResponseEntity<String> saveTask(@RequestBody Task task) throws URISyntaxException {
        return new ResponseEntity<>(CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return new ResponseEntity<>(OK);
    }
}
