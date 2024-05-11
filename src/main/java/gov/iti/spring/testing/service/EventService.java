package gov.iti.spring.testing.service;

import gov.iti.spring.testing.domain.Event;
import java.util.List;

public interface EventService {
    List<Event> getAll();

    Event getById(Long id);
}

