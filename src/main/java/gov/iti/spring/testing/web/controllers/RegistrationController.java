package gov.iti.spring.testing.web.controllers;


import gov.iti.spring.testing.service.RegistrationService;
import gov.iti.spring.testing.web.dtos.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/events/register")
    public ResponseEntity<String> register(@RequestBody RegistrationDto registrationDto) {
        registrationService.register(registrationDto);
        return ResponseEntity.ok("ddd");
    }
}
