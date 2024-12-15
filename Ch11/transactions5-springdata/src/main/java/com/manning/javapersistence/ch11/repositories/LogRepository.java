 package com.manning.javapersistence.ch11.repositories;

import com.manning.javapersistence.ch11.concurrency.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer>, LogRepositoryCustom {
}
