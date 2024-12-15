 package com.manning.javapersistence.testing.service;

import com.manning.javapersistence.testing.model.User;
import com.manning.javapersistence.testing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional//(propagation = Propagation.REQUIRES_NEW)
    public void saveTransactionally(User user) {
        userRepository.save(user);
    }
}
