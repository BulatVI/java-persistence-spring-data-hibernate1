 package com.manning.javapersistence.springdatamongodb.repository;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QueryByMatcherTest extends SpringDataMongoDBApplicationTests {

    @Test
    void findByMatcher() {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("level")
                .withIgnorePaths("active");

        User probe = new User();
        probe.setLastName("Smith");

        List<User> result = userRepository.findAll(Example.of(probe, matcher));

        assertThat(result).hasSize(2)
                .extracting("username").contains("john", "burk");
    }

}
