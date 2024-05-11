package gov.iti.spring.testing.web.controllers;

import gov.iti.spring.testing.service.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {

    @Mock
    private HelloService helloService;
    @InjectMocks
    private HelloController cut;
    @BeforeEach
    public void beforeAll(){
        when(helloService.sayHello()).thenReturn("hello");
    }
    @Test
    public void helloTest(){

        //act
        ResponseEntity<String> greeting = cut.greeting();

        //assert
        Assertions.assertThat(greeting.getBody()).isEqualTo("hello");
    }
}