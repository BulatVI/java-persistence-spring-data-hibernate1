 package com.manning.javapersistence.testing;

import com.manning.javapersistence.testing.model.User;
import com.manning.javapersistence.testing.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
class TransactionsManagementTest {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private LogRepository logRepository;

    @BeforeTransaction
    void beforeTransaction() {
        Assumptions.assumeFalse(TransactionSynchronizationManager.isActualTransactionActive());
//        logRepository.save(new Log("@BeforeTransaction"));
    }


    @RepeatedTest(2)
//    @Rollback(value = false)
//    @Commit
    void storeUpdateRetrieve() {
        Assumptions.assumeTrue(TransactionSynchronizationManager.isActualTransactionActive());

        List<User> users = UsersHelper.buildUsersList();
        userRepository.saveAll(users);

        for (User user : users) {
            user.setName("Updated " + user.getName());
        }

        userRepository.saveAll(users);

        Assertions.assertEquals(UsersHelper.getIterations(), userRepository.findAll().size());

    }

    @AfterTransaction
    void afterTransaction() {
        Assumptions.assumeFalse(TransactionSynchronizationManager.isActualTransactionActive());
//        logRepository.save(new Log("@AfterTransaction"));
    }

}
