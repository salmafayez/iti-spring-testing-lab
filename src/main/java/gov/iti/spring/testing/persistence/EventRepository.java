package gov.iti.spring.testing.persistence;


import gov.iti.spring.testing.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
