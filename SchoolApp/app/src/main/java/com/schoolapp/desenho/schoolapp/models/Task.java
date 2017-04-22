package com.schoolep.desenho.schoolapp.models;

import java.sql.Date;

public class Task extends Event {
    private String taskDescription;

    public Task(Integer eventId, Date dateEvent, Date startTime, Date endTime, String localEvent, String discipline,
                Integer disciplineClassId, String taskDescription) {
        super(eventId, dateEvent, startTime, endTime, localEvent, discipline, disciplineClassId);
        setTaskDescription(taskDescription);
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
