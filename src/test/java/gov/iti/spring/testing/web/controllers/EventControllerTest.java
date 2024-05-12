package gov.iti.spring.testing.web.controllers;

import gov.iti.spring.testing.service.UserService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class EventControllerTest {

    @Autowired
    MockMvc mockMvc ;
    @MockBean
    UserService userService ;

    void shouldReturnStatus200WhenRequestGet (){
        Mockito.when(userService.getAll(1) ).thenReturn(
                List.of()
        )

    }



}