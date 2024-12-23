 
package com.manning.javapersistence.ch09.onetoone.foreignkey;

import com.manning.javapersistence.ch09.configuration.onetoone.foreignkey.SpringDataConfiguration;
import com.manning.javapersistence.ch09.repositories.onetoone.foreignkey.AddressRepository;
import com.manning.javapersistence.ch09.repositories.onetoone.foreignkey.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class AdvancedMappingSpringDataJPATest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void testStoreLoadEntities() {

        User john =
                new User("John Smith");

        Address address =
                new Address("Flowers Street", "01246", "Boston");

        john.setShippingAddress(address);

        userRepository.save(john);

        User user = userRepository.findUserWithAddress(john.getId());
        Address address2 = addressRepository.findById(address.getId()).get();

        assertAll(
                () -> assertEquals("Flowers Street", user.getShippingAddress().getStreet()),
                () -> assertEquals("01246", user.getShippingAddress().getZipcode()),
                () -> assertEquals("Boston", user.getShippingAddress().getCity()),
                () -> assertEquals("Flowers Street", address2.getStreet()),
                () -> assertEquals("01246", address2.getZipcode()),
                () -> assertEquals("Boston", address2.getCity())
        );

    }
}
