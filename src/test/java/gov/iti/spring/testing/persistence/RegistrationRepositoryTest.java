package gov.iti.spring.testing.persistence;

import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.domain.enums.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer("postgres:13.2")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @Test
    void testFindingUserByEmail() {
        //Arrange
        User user = new User();
        user.setEmail("menna@gmail.com");
        user.setFirstName("Menna");
        user.setLastName("Moataz");
        user.setPassword("12345678");
        user.setRole(UserRole.ORGANIZER);
        //Act
        userRepository.save(user);
        User foundUser = userRepository.findByEmail("menna@gmail.com").get();
        //Assert
        Assertions.assertThat(foundUser.getEmail()).isEqualTo("menna@gmail.com");
    }
}