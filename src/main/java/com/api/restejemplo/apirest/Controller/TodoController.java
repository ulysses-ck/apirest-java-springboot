package com.api.restejemplo.apirest.Controller;

import com.api.restejemplo.apirest.Model.Task;
import com.api.restejemplo.apirest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value="/")
    public String helloWorld() {
        return "Hello world";

    }

    @GetMapping(value="/tasks")
    public List<Task> getTasks () {

        return todoRepository.findAll();
    }


    @PostMapping(value="/savetask")
    public String saveTask(@RequestBody Task task) {

        todoRepository.save(task);
        return "Saved Task";
    }

    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task) {
        Task updatedTask= todoRepository.findById(id).get();

        //update task properties
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());

        todoRepository.save(updatedTask);

        return "Updated task " + updatedTask.getId();
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        Task deletedTask = todoRepository.findById(id).get();

        todoRepository.delete(deletedTask);

        return "Deleted task " + deletedTask.getId();

    }


}
