package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import ru.geekbrains.persistence.UserRepository;
import ru.geekbrains.persistence.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAllWithoutProductsUser() {
        return userRepository.findAllWithoutProductsUsers();
    }

    @Transactional(readOnly = true)
    public Optional<User> findByIdWithProductsUser(Long id) {
        return userRepository.findByIdWithProductsUsers(id);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

}
