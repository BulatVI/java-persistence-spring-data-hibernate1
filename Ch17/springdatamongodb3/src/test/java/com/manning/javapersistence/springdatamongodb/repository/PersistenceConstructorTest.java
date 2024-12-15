 package com.manning.javapersistence.springdatamongodb.repository;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceConstructorTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testPersistenceConstructor() {
        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getUsername());
            assertEquals("192.168.1.100", user.getIp());
        });
    }

}
