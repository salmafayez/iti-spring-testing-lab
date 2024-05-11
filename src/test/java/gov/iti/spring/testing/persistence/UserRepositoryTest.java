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

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer("postgres:13.2")
            .withDatabaseName("db")
            .withUsername("user")
            .withPassword("1234");

    @Test
    void findByEmail() {
        // Arrange
        User user = new User();
        user.setEmail("Mohammed@gmail.com");
        user.setPassword("1234@Mohammed");
        user.setFirstName("Mohammed");
        user.setLastName("Mohammed");
        user.setRole(UserRole.ATTENDEE);

        // Act
        userRepository.save(user);
        User foundUser = userRepository.findByEmail("Mohammed@gmail.com").orElse(null);

        // Assert
        assertNotNull(foundUser);
    }
}
