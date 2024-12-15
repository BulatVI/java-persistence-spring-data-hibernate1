 package com.manning.javapersistence.springdatamongodb.template;

import com.manning.javapersistence.springdatamongodb.model.User;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UpsertTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testUpsert() {
        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(1));

        Update update = new Update();
        update.set("level", 2);
        UpdateResult result = mongoTemplate.upsert(query, update, User.class);

        assertAll(
                () -> assertEquals(1, result.getMatchedCount()),
                () -> assertEquals(1, result.getModifiedCount())
        );

    }
}

