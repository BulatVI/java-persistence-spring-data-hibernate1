 package com.manning.javapersistence.springdatamongodb.repository;

import com.manning.javapersistence.springdatamongodb.model.User;
import com.manning.javapersistence.springdatamongodb.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QueryByExampleTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByExample() {

        userRepository.deleteAll();

        userRepository.save(new User("john", "John", "Smith"));
        userRepository.save(new User("stephanie", "Stephanie", "Christensen"));
        userRepository.save(new User("burk", "Burk", "Smith"));


        User probe = new User(null, null, "Smith");

        List<User> result = userRepository.findAll(Example.of(probe));

        assertThat(result).hasSize(2)
                .extracting("username").contains("john", "burk");

        userRepository.deleteAll();
    }
}
