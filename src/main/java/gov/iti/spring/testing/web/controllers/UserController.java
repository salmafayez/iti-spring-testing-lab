package gov.iti.spring.testing.web.controllers;

import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, defaultValue = "10") int pageSize,
                                               @RequestParam(required = false, defaultValue = "0") int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        User addUser = userService.createUser(user);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(addUser.getId()).toUri())
                .body("added successfully");
    }

    @PostMapping("/users/{id}/photo")
    public ResponseEntity<String> addUserPhoto(@PathVariable Long id, MultipartFile image) {
        userService.addUserPhoto(id, image);
        return ResponseEntity.ok("added photo");
    }

    @DeleteMapping("/private/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("deleted successfully");
    }

}
