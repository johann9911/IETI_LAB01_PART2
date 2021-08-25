package edu.eci.lab01_part2_RestFull.model;

import edu.eci.lab01_part2_RestFull.data.Task;
import edu.eci.lab01_part2_RestFull.dto.TaskDto;

public class MapperClasses {

    public static Task toTask(TaskDto taskDto) {
        Task newTask = new Task(null, taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getStatus(),
                taskDto.getAssignedTo(),
                taskDto.getDueDate(),
                taskDto.getCreated());
        return newTask;
    }
}
