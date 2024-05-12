package gov.iti.spring.testing.persistence;


import gov.iti.spring.testing.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;



@DataJpaTest(properties = {
        "spring.flyway.enabled=false" ,
                "spring.jpa.generate-ddl-auto=create-drop"

})

public class UserRepositoryTestByWorkAround {

    @Autowired
    UserRepository userRepository;

    @Test
    void UserRepository_isCreated_CheckDataBaseTableCreatedAndEmpty(){
        assertThat(userRepository.findAll().isEmpty() );
    }




}
