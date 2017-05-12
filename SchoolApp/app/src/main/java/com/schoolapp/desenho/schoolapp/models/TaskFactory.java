package com.schoolapp.desenho.schoolapp.models;

class TaskFactory extends AbstractFactory {

    @Override
    public Event createEvent(Integer eventId, Date dateEvent, Date startTime,
                Date endTime, String localEvent, Integer disciplineClassId,
                String taskDescription) {
        return new Task(eventId, dateEvent, startTime, endTime, localEvent,
                      disciplineClassId);
    }

}
