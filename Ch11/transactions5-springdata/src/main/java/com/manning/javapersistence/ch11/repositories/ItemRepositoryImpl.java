 package com.manning.javapersistence.ch11.repositories;

import com.manning.javapersistence.ch11.concurrency.Item;
import com.manning.javapersistence.ch11.concurrency.Log;
import com.manning.javapersistence.ch11.exceptions.DuplicateItemNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private LogRepository logRepository;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void checkNameDuplicate(String name) {
        if (itemRepository.findAll().stream().map(item -> item.getName()).filter(n -> n.equals(name)).count() > 0) {
            throw new DuplicateItemNameException("Item with name " + name + " already exists");
        }
    }

    @Override
    @Transactional
    public void addItem(String name, LocalDate creationDate) {
        logRepository.log("adding item with name " + name);
        checkNameDuplicate(name);
        itemRepository.save(new Item(name, creationDate));
    }

    @Override
    @Transactional(noRollbackFor = DuplicateItemNameException.class)
    public void addItemNoRollback(String name, LocalDate creationDate) {
        logRepository.save(new Log("adding log in method with no rollback for item " + name));
        checkNameDuplicate(name);
        itemRepository.save(new Item(name, creationDate));
    }

    @Override
    @Transactional
    public void addLogs() {
        logRepository.addSeparateLogsNotSupported();
    }

    @Override
    @Transactional
    public void showLogs() {
        logRepository.showLogs();
    }

}
