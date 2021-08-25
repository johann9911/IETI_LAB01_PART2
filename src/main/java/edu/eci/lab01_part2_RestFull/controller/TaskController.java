package edu.eci.lab01_part2_RestFull.controller;

import edu.eci.lab01_part2_RestFull.data.Task;
import edu.eci.lab01_part2_RestFull.dto.TaskDto;
import edu.eci.lab01_part2_RestFull.model.MapperClasses;
import edu.eci.lab01_part2_RestFull.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> all(){

        return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(MapperClasses.toTask(userDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> create(@PathVariable String id, @RequestBody TaskDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(MapperClasses.toTask(userDto),id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> create(@PathVariable String id){
        taskService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
