 package com.manning.javapersistence.ch15;

import com.manning.javapersistence.ch15.model.Address;
import com.manning.javapersistence.ch15.model.User;
import com.manning.javapersistence.ch15.repositories.AddressOneToManyRepository;
import com.manning.javapersistence.ch15.repositories.UserOneToManyRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserAddressOneToManyTest {

    @Autowired
    private UserOneToManyRepository userOneToManyRepository;

    @Autowired
    private AddressOneToManyRepository addressOneToManyRepository;

    private static List<User> users = new ArrayList<>();

    @BeforeAll
    void beforeAll() {
        userOneToManyRepository.saveAll(generateUsers());
    }

    @Test
    void oneToManyTest() {

        assertAll(
                () -> assertEquals(10, userOneToManyRepository.count()),
                () -> assertEquals(20, addressOneToManyRepository.count()),
                () -> assertEquals(2, addressOneToManyRepository.countByUserId(users.get(0).getId()))
        );

    }

    private static Address generateAddress(String number) {
        Address address = new Address();
        address.setCity("New York");
        address.setStreet(number + ", 5th Avenue");
        return address;
    }

    private static List<User> generateUsers() {
        User john = new User("john", LocalDate.of(2020, Month.APRIL, 13));
        john.setEmail("john@somedomain.com");
        john.setLevel(1);
        john.setActive(true);
        john.addAddress(generateAddress("11"));
        john.addAddress(generateAddress("21"));

        User mike = new User("mike", LocalDate.of(2020, Month.JANUARY, 18));
        mike.setEmail("mike@somedomain.com");
        mike.setLevel(3);
        mike.setActive(true);
        mike.addAddress(generateAddress("12"));
        mike.addAddress(generateAddress("22"));

        User james = new User("james", LocalDate.of(2020, Month.MARCH, 11));
        james.setEmail("james@someotherdomain.com");
        james.setLevel(3);
        james.setActive(false);
        james.addAddress(generateAddress("13"));
        james.addAddress(generateAddress("23"));

        User katie = new User("katie", LocalDate.of(2021, Month.JANUARY, 5));
        katie.setEmail("katie@somedomain.com");
        katie.setLevel(5);
        katie.setActive(true);
        katie.addAddress(generateAddress("14"));
        katie.addAddress(generateAddress("24"));

        User beth = new User("beth", LocalDate.of(2020, Month.AUGUST, 3));
        beth.setEmail("beth@somedomain.com");
        beth.setLevel(2);
        beth.setActive(true);
        beth.addAddress(generateAddress("15"));
        beth.addAddress(generateAddress("25"));

        User julius = new User("julius", LocalDate.of(2021, Month.FEBRUARY, 9));
        julius.setEmail("julius@someotherdomain.com");
        julius.setLevel(4);
        julius.setActive(true);
        julius.addAddress(generateAddress("16"));
        julius.addAddress(generateAddress("26"));

        User darren = new User("darren", LocalDate.of(2020, Month.DECEMBER, 11));
        darren.setEmail("darren@somedomain.com");
        darren.setLevel(2);
        darren.setActive(true);
        darren.addAddress(generateAddress("17"));
        darren.addAddress(generateAddress("27"));

        User marion = new User("marion", LocalDate.of(2020, Month.SEPTEMBER, 23));
        marion.setEmail("marion@someotherdomain.com");
        marion.setLevel(2);
        marion.setActive(false);
        marion.addAddress(generateAddress("18"));
        marion.addAddress(generateAddress("28"));

        User stephanie = new User("stephanie", LocalDate.of(2020, Month.JANUARY, 18));
        stephanie.setEmail("stephanie@someotherdomain.com");
        stephanie.setLevel(4);
        stephanie.setActive(true);
        stephanie.addAddress(generateAddress("19"));
        stephanie.addAddress(generateAddress("29"));

        User burk = new User("burk", LocalDate.of(2020, Month.NOVEMBER, 28));
        burk.setEmail("burk@somedomain.com");
        burk.setLevel(1);
        burk.setActive(true);
        burk.addAddress(generateAddress("10"));
        burk.addAddress(generateAddress("20"));

        users.add(john);
        users.add(mike);
        users.add(james);
        users.add(katie);
        users.add(beth);
        users.add(julius);
        users.add(darren);
        users.add(marion);
        users.add(stephanie);
        users.add(burk);

        return users;
    }

    @AfterAll
    void afterAll() {
        userOneToManyRepository.deleteAll();
    }

}
