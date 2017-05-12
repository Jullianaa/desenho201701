package com.schoolapp.desenho.schoolapp.models;

class MonitoryFactory extends AbstractFactory {

    @Override
    public Event createEvent(Integer eventId, Date dateEvent, Date startTime,
                    Date endTime, String localEvent, Integer disciplineClassId,
                    String monitor) {
        return new Monitory(eventId, dateEvent, startTime, endTime, localEvent,
                    disciplineClassId);
    }

}
