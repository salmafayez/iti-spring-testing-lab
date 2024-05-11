package gov.iti.spring.testing.persistence;

import gov.iti.spring.testing.domain.Ticket;
import gov.iti.spring.testing.domain.enums.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTicketByTypeAndEvent_Id(TicketType ticketType, Long eventId);

    Ticket findAllTicketsByTypeAndEvent_Id(TicketType ticketType, Long eventId);

}
