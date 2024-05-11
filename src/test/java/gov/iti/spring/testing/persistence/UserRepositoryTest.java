package gov.iti.spring.testing.persistence;

import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.domain.enums.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/*(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})*/

class UserRepositoryTest extends AbstractClass {
    @Test
    void testInsertion(){
        User newUser = User.builder()
                .email("hassan@gmai.com")
                .role(UserRole.ORGANIZER)
                .firstName("hassan")
                .lastName("kamal")
                .password("ss")
                .build();

        userRepository.save(newUser);
        Assertions.assertThat(userRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void test(){
        Assertions.assertThat(userRepository.findAll().size()).isEqualTo(0);
    }
}