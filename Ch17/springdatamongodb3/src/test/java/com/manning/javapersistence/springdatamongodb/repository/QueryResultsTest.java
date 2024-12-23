 package com.manning.javapersistence.springdatamongodb.repository;

import com.manning.javapersistence.springdatamongodb.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QueryResultsTest extends SpringDataMongoDBApplicationTests {

    @Test
    void testStreamable() {
        try (Stream<User> result = userRepository.findByEmailContaining("someother")
                .and(userRepository.findByLevel(2))
                .stream().distinct()) {
            assertEquals(7, result.count());
        }
    }

    @Test
    void testQueries() {
        int smiths = userRepository.findUsersByLastName("Smith").size();
        int inactive = userRepository.findUsersByActive(false).size();
        int active = userRepository.findUsersByActive(true).size();

        assertAll(
                () -> assertEquals(2, inactive),
                () -> assertEquals(8, active),
                () -> assertEquals(2, smiths)
        );
    }

    @Test
    void testRegExpQueries() {
        List<User> users = userRepository.findUsersByRegexpLastName("^S");

        assertEquals(4, users.size());
    }

    @Test
    void testLevelBetween() {
        List<User> users = userRepository.findUsersByLevelBetween(3, 4);

        assertEquals(4, users.size());
    }

    @Test
    void testFindUsernameAndId() {
        List<User> users = userRepository.findUsernameAndId();

        users.forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getUsername());
            assertNull(user.getLastName());
            assertNull(user.getFirstName());
            assertNull(user.getRegistrationDate());
            assertNull(user.getEmail());
            assertEquals(0, user.getLevel());
            assertFalse(user.isActive());
        });
    }

    @Test
    void testFindUsersExcludeId() {
        List<User> users = userRepository.findUsersExcludeId();

        users.forEach(user -> {
            assertNull(user.getId());
            assertNotNull(user.getUsername());
            assertNotNull(user.getLastName());
            assertNotNull(user.getFirstName());
            assertNotNull(user.getRegistrationDate());
            assertNotNull(user.getEmail());
            assertNotEquals(0, user.getLevel());
        });
    }

    @Test
    void testFindUsersByRegexpLastNameExcludeId() {
        List<User> users = userRepository.findUsersByRegexpLastNameExcludeId("^S");

        users.forEach(user -> {
            assertNull(user.getId());
            assertNotNull(user.getUsername());
            assertNotNull(user.getLastName());
            assertTrue(user.getLastName().startsWith("S"));
            assertNotNull(user.getFirstName());
            assertNotNull(user.getRegistrationDate());
            assertNotNull(user.getEmail());
            assertNotEquals(0, user.getLevel());
        });
    }


}
