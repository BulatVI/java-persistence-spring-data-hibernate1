package com.manning.javapersistence.ch07;

import com.manning.javapersistence.ch07.model.BankAccount;
import com.manning.javapersistence.ch07.model.BillingDetails;
import com.manning.javapersistence.ch07.model.CreditCard;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MappingInheritanceJPATest {

    @Test
    void storeLoadEntities() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ch07.mapping_inheritance");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            CreditCard creditCard = new CreditCard("John Smith", "123456789", "10", "2030");
            BankAccount bankAccount = new BankAccount("Mike Johnson", "12345", "Delta Bank", "BANKXY12");
            em.persist(creditCard);
            em.persist(bankAccount);

            em.getTransaction().commit();
            em.refresh(creditCard);
            em.refresh(bankAccount);

            em.getTransaction().begin();

            List<BillingDetails> billingDetails =
                    em.createQuery("select bd from BillingDetails bd", BillingDetails.class)
                            .getResultList();

            em.getTransaction().commit();

            assertAll(
                    () -> assertEquals(2, billingDetails.size())
            );
        } finally {
            em.close();
            emf.close();
        }
    }
}
