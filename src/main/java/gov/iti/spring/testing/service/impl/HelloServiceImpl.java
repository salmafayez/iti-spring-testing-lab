package gov.iti.spring.testing.service.impl;

import gov.iti.spring.testing.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello" ;
    }
}
