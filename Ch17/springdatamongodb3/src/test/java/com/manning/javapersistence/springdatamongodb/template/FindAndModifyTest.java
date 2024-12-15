 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAndModifyTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testFindAndModify() {
        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(1));

        Update update = new Update();
        update.set("level", 2);
        User user = mongoTemplate.findAndModify(query, update, User.class);

        assertEquals(1, user.getLevel());

    }
}
