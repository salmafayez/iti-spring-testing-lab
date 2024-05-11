package gov.iti.spring.testing.persistence;

import gov.iti.spring.testing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
