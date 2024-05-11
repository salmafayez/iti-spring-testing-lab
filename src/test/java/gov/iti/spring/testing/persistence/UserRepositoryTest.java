package gov.iti.spring.testing.persistence;

import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.domain.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer("postgres:13.2")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @Test
    void findByEmail() {
        // Arrange
        User user = new User();
        String email = "user@gmail.com";
        user.setEmail(email);
        user.setPassword("password");
        user.setFirstName("User");
        user.setLastName("User");
        user.setRole(UserRole.ATTENDEE);

        userRepository.save(user);

        // Act
        User foundUser = userRepository.findByEmail(email).orElse(null);

        // Assert
        assertNotNull(foundUser);
    }
}