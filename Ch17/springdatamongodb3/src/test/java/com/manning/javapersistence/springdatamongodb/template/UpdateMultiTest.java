 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateMultiTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testUpdateMulti() {
        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(1));

        Update update = new Update();
        update.set("level", 2);
        mongoTemplate.updateMulti(query, update, User.class);

        List<User> users = mongoTemplate.find(query, User.class);

        assertEquals(0, users.size());

    }
}
