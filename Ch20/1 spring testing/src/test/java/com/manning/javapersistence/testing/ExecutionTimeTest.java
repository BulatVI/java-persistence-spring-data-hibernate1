 package com.manning.javapersistence.testing;

import com.manning.javapersistence.testing.model.User;
import com.manning.javapersistence.testing.repositories.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.manning.javapersistence.testing.UsersHelper.buildUsersList;
import static com.manning.javapersistence.testing.UsersHelper.getIterations;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
class ExecutionTimeTest {

    @Autowired
    private UserRepository userRepository;

    private static long time1;

    private static long time2;

    @BeforeAll
    static void beforeAll() {
        time1 = System.nanoTime();
    }

    @RepeatedTest(10)
    void storeUpdateRetrieve() {
        List<User> users = buildUsersList();
        userRepository.saveAll(users);

        for (User user : users) {
            user.setName("Updated " + user.getName());
        }

        userRepository.saveAll(users);

        assertEquals(getIterations(), userRepository.findAll().size());

    }

    @AfterAll
    static void afterAll() {
        time2 = System.nanoTime();

        long timeDiff = (time2 - time1) / 1000_000;
        System.out.println("Execution time: " + timeDiff);
    }

}
