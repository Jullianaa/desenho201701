package com.schoolep.desenho.schoolep.models;

import java.util.Date;

public class Task extends Event {
    private String taskDescription;

    public Task(Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline, String taskDescription) {
        super(dateEvent, startTime, endTime, localEvent, discipline);
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
