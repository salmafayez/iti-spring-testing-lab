package gov.iti.spring.testing.service;

import gov.iti.spring.testing.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    Page<User> getAll(Pageable pageable);

    User getById(Long id);

    User createUser(User user);

    void addUserPhoto(Long id, MultipartFile image);

    void deleteUser(Long id);
}
