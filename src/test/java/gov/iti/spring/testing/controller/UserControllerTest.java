package gov.iti.spring.testing.controller;

import gov.iti.spring.testing.config.WebSecurityConfig;
import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.domain.enums.UserRole;
import gov.iti.spring.testing.service.UserService;
import gov.iti.spring.testing.web.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(WebSecurityConfig.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void findUserByEmail() throws Exception {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setEmail("Mohammed@gmail.com");
        user.setPassword("1234@Mohammed");
        user.setFirstName("Mohammed");
        user.setLastName("Mohammed");
        user.setRole(UserRole.ATTENDEE);
        // Act
        given(userService.getById(1L)).willReturn(user);

        // Assert
        mockMvc.perform(get("/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("Mohammed@gmail.com"));

    }
}
