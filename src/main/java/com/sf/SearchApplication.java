package com.sf;

import com.sf.entity.Contact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.sf.repository.ContactRepository;
import com.sf.repository.test.TestRepository;

@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
            SpringApplication.run(SearchApplication.class, args);
    }
        
    @Bean
    public CommandLineRunner loadData(ContactRepository repository,
            TestRepository testRepository) {
        return (args) -> {
            testRepository.persistToDB();
        };
    } 
}
