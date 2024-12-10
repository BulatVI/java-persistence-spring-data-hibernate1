 
package com.manning.javapersistence.ch07;

import com.manning.javapersistence.ch07.configuration.SpringDataConfiguration;
import com.manning.javapersistence.ch07.model.CreditCard;
import com.manning.javapersistence.ch07.model.User;
import com.manning.javapersistence.ch07.repositories.CreditCardRepository;
import com.manning.javapersistence.ch07.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
class MappingInheritanceSpringDataJPATest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Test
    void storeLoadEntities() {

        CreditCard creditCard = new CreditCard(
                "John Smith", "123456789", "10", "2030"
        );
        User john = new User("John Smith");
        john.setDefaultBilling(creditCard);

        creditCardRepository.save(creditCard);
        userRepository.save(john);

        User user = userRepository.findById(john.getId()).get();

        System.out.println(user.getDefaultBilling());

        user.getDefaultBilling().pay(123);

        assertAll(
                () -> assertEquals("John Smith", user.getDefaultBilling().getOwner())
        );

    }

}
