 
package com.manning.javapersistence.ch07.repositories;

import com.manning.javapersistence.ch07.model.CreditCard;

import java.util.List;

public interface CreditCardRepository extends BillingDetailsRepository<CreditCard, Long> {
    List<CreditCard> findByCardNumber(String cardNumber);
}
