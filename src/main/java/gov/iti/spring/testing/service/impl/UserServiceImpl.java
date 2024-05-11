package gov.iti.spring.testing.service.impl;

import gov.iti.spring.testing.domain.User;
import gov.iti.spring.testing.persistence.UserRepository;
import gov.iti.spring.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user with this id"));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addUserPhoto(Long id, MultipartFile image) {

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
