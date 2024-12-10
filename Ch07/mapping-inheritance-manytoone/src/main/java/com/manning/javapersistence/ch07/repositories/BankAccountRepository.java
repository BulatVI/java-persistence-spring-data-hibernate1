package com.manning.javapersistence.ch07.repositories;

import com.manning.javapersistence.ch07.model.BankAccount;

import java.util.List;

public interface BankAccountRepository extends BillingDetailsRepository<BankAccount, Long> {
    List<BankAccount> findBySwift(String swift);
}
