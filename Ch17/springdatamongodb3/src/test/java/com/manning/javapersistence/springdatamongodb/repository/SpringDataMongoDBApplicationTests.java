 package com.manning.javapersistence.springdatamongodb.repository;

import com.manning.javapersistence.springdatamongodb.GenerateUsers;
import com.manning.javapersistence.springdatamongodb.repositories.AddressRepository;
import com.manning.javapersistence.springdatamongodb.repositories.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.manning.javapersistence.springdatamongodb.GenerateUsers.generateUsers;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class SpringDataMongoDBApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @BeforeAll
    void beforeAll() {
        addressRepository.save(GenerateUsers.address);
        userRepository.saveAll(generateUsers());
    }


    @AfterAll
    void afterAll() {
        userRepository.deleteAll();
        addressRepository.deleteAll();
    }


}
