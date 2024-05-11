package gov.iti.spring.testing.web.controllers;

import gov.iti.spring.testing.service.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@SpringBootTest
public class HelloController2Test {

    @Autowired
    private HelloService helloService;
    @Autowired
    private HelloController cut;
    @Test
    public void helloTest(){

        //act
        ResponseEntity<String> greeting = cut.greeting();

        //assert
        Assertions.assertThat(greeting.getBody()).isEqualTo("hello");
    }
}