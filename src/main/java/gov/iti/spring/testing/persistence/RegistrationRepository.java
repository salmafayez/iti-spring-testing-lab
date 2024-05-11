package gov.iti.spring.testing.persistence;

import gov.iti.spring.testing.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> getRegistrationByUserEmailAndRegistrationDateAfter(String email, LocalDateTime date);
}
