package com.manning.javapersistence.ch07;

import com.manning.javapersistence.ch07.configuration.SpringDataConfiguration;
import com.manning.javapersistence.ch07.model.BankAccount;
import com.manning.javapersistence.ch07.model.BillingDetails;
import com.manning.javapersistence.ch07.model.CreditCard;
import com.manning.javapersistence.ch07.repositories.BillingDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
class MappingInheritanceSpringDataJPATest {

    @Autowired
    private BillingDetailsRepository<BillingDetails, Long> billingDetailsRepository;

    @Test
    void storeLoadEntities() {

        CreditCard creditCard = new CreditCard("John Smith", "123456789", "10", "2030");
        billingDetailsRepository.save(creditCard);

        BankAccount bankAccount = new BankAccount("Mike Johnson", "12345", "Delta Bank", "BANKXY12");
        billingDetailsRepository.save(bankAccount);

        List<BillingDetails> billingDetails = billingDetailsRepository.findAll();
        List<BillingDetails> billingDetails2 = billingDetailsRepository.findByOwner("John Smith");

        assertAll(
                () -> assertEquals(2, billingDetails.size()),
                () -> assertEquals(1, billingDetails2.size()),
                () -> assertEquals("John Smith", billingDetails2.get(0).getOwner())
        );

    }

}
