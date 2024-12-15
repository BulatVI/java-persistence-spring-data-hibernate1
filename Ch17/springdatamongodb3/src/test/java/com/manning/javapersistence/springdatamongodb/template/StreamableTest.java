 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamableTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testStreamable() {
        Query query = new Query(new Criteria().orOperator(Criteria.where("email").regex(".*someother.*"), Criteria.where("level").is(2)));
        try (Stream<User> result = mongoTemplate.stream(query, User.class).stream().distinct()) {
            assertEquals(6, result.count());
        }
    }

}
