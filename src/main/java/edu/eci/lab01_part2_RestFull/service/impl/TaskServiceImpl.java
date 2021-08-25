package edu.eci.lab01_part2_RestFull.service.impl;

import edu.eci.lab01_part2_RestFull.data.Task;
import edu.eci.lab01_part2_RestFull.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskServiceImpl implements TaskService {

    HashMap<String, Task> tasks = new HashMap<String, Task>();
    private AtomicInteger cont = new AtomicInteger(1);

    private Integer generateId() {
        return cont.getAndIncrement();
    }

    @Override
    public Task create(Task task) {
        String newId = generateId().toString();
        task.setId(newId);
        tasks.put(newId, task);
        return task;
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> all() {
        List<Task> allTasks = new ArrayList<Task>();
        for(Task i : tasks.values()){
            allTasks.add(i);
        }
        return allTasks;
    }

    @Override
    public void deleteById(String id) {
        tasks.remove(id);
    }

    @Override
    public Task update(Task task, String id) {
        task.setId(id);
        tasks.put(id,task);
        return task;
    }
}
