 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersistenceConstructorTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testPersistenceConstructor() {
        List<User> users = mongoTemplate.find(new Query(), User.class);

        users.forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getUsername());
            assertEquals("192.168.1.100", user.getIp());
        });
    }

}
