package gov.iti.spring.testing.persistence;


import gov.iti.spring.testing.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class UserRepositoryTestByContainers {

    @DynamicPropertySource
    static void proberties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",postgreSQLContaine::getJdbcUrl );
        registry.add("spring.datasource.username", postgreSQLContaine::getUsername);
        registry.add("spring.datasource.password",postgreSQLContaine::getPassword );

    }
    @Container
    static PostgreSQLContainer postgreSQLContaine = new PostgreSQLContainer("postgres:12.3")
            .withDatabaseName("testing")
            .withUsername("user")
            .withPassword("password");

    @Autowired
    UserRepository userRepository;

    @Test
    void UserRepository_isCreated_CheckDataBaseTableCreatedAndEmpty(){
        assertThat(userRepository.findAll().isEmpty() );
    }




}
