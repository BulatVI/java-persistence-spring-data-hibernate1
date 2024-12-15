 package com.manning.javapersistence.springdatamongodb;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransientTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testTransientField() {
        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getUsername());
            assertNull(user.getPassword());
        });
    }

}
