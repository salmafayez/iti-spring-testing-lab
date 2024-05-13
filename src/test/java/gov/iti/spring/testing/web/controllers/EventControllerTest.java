package gov.iti.spring.testing.web.controllers;


import gov.iti.spring.testing.config.WebSecurityConfig;
import gov.iti.spring.testing.domain.Event;
import gov.iti.spring.testing.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EventController.class)
@Import(WebSecurityConfig.class)
class EventControllerTest {

    @Autowired
    private EventController eventController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    // Add tests here

    @Test
    void testGetAllEvents() throws Exception {
        when(eventService.getAll()).thenReturn(List.of(new Event(), new Event()));

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/events").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();



    }
}
