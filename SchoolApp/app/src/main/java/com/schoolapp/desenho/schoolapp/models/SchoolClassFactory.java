package com.schoolapp.desenho.schoolapp.models;

class SchoolClassFactory extends AbstractFactory {

    @Override
    public Event createEvent(Integer eventId, Date dateEvent, Date startTime,
                    Date endTime, String localEvent, Integer disciplineClassId,
                    Integer absentClass) {
        return new SchoolClass(eventId, dateEvent, startTime, endTime,
                    localEvent, disciplineClassId);
    }

}
