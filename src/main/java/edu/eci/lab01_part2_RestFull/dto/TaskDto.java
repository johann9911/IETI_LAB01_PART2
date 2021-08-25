package edu.eci.lab01_part2_RestFull.dto;

import edu.eci.lab01_part2_RestFull.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class TaskDto {

    private String name;
    private String description;
    private TaskStatus status;
    private String assignedTo;
    private Date dueDate;
    private Date created;

}
