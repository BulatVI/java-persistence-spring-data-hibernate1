 package com.manning.javapersistence.ch16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import com.manning.javapersistence.ch16.beans.CsvDataLoader;
import com.manning.javapersistence.ch16.model.Auction;
import com.manning.javapersistence.ch16.model.User;
import com.manning.javapersistence.ch16.repositories.UserRepository;

@SpringBootApplication
@Import(CsvDataLoader.class)
public class Application {

    @Autowired
    private Auction auction;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner configureRepository(UserRepository userRepository) {
        return args -> {

            for (User user : auction.getUsers()) {
                userRepository.save(user);
            }

        };
    }
}
