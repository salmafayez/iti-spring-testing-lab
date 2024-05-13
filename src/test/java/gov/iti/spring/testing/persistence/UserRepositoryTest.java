package gov.iti.spring.testing.persistence;


import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.domain.enums.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class UserRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:16.3")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");
//    static {
//        postgreSQLContainer.start();
//    }


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private TestEntityManager tem;

    @Test
    void testFindAll() {
        User user = User.builder().
                email("yousif@gmail.com").
                firstName("yousif").
                lastName("hossam").
                password("12345678").
                role(UserRole.ORGANIZER).
                build();
        tem.persist(user);
        Assertions.assertThat(userRepository.findAll().size()).isEqualTo(1);

    }



}
