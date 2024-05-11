package gov.iti.spring.testing.service;


import gov.iti.spring.testing.web.dtos.RegistrationDto;

public interface RegistrationService {
    void register(RegistrationDto registrationDto);
}
