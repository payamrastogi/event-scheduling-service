package com.coddicted.appointment.repository;

import com.coddicted.appointment.model.Event;
import com.coddicted.appointment.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

}
