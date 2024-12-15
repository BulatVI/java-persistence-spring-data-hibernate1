 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveUpdateTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testSaveUpdate() {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("level").is(1)), User.class);
        user.setLevel(2);
        mongoTemplate.save(user, "user");

        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(1));

        List<User> users = mongoTemplate.find(query, User.class);

        assertEquals(1, users.size());

    }
}
