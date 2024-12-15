 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.GenerateUsers;
import com.manning.javapersistence.springdatamongodb.model.Address;
import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static com.manning.javapersistence.springdatamongodb.GenerateUsers.generateUsers;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class SpringDataMongoDBApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeAll
    void beforeAll() {
        mongoTemplate.insert(GenerateUsers.address);
        mongoTemplate.insert(generateUsers(), User.class);
    }

    @AfterAll
    void afterAll() {
        mongoTemplate.remove(new Query(), User.class);
        mongoTemplate.remove(new Query(), Address.class);
    }
}
