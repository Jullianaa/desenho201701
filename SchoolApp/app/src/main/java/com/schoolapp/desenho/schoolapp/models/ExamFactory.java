package com.schoolapp.desenho.schoolapp.models;

import java.util.Date;

class ExamFactory extends AbstractFactory {

    @Override
    public Event createEvent(Integer eventId, Integer disciplineClassId,
                Date dateEvent, Date startTime, Date endTime, String localEvent,
                Float grade, String contentExam) {
        return new Exam(eventId, dateEvent, startTime, endTime, localEvent, disciplineClassId);
    }

}
