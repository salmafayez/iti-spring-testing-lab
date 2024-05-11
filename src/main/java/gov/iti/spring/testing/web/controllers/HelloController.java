package gov.iti.spring.testing.web.controllers;

import gov.iti.spring.testing.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public ResponseEntity<String> greeting() {
        String result = helloService.sayHello();
        return ResponseEntity.ok(result);
    }
}
