 package com.manning.javapersistence.ch15;

import com.manning.javapersistence.ch15.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteQueryTest extends SpringDataJdbcApplicationTests {

    @Test
    void testDeleteByLevel() {
        int deleted = userRepository.deleteByLevel(2);
        List<User> users = userRepository.findByLevel(2, Sort.by("username"));
        assertAll(
                () -> assertEquals(3, deleted),
                () -> assertEquals(0, users.size())
        );

    }
}
