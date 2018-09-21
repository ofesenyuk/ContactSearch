package com.sf;

import com.sf.entity.Contact;
import com.sf.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
            SpringApplication.run(SearchApplication.class, args);
    }
        
    @Bean
    public CommandLineRunner loadData(ContactRepository repository) {
        return (args) -> {
            repository.save(new Contact(null, "Sasha"));
            repository.save(new Contact(null, "Pasha"));
            repository.save(new Contact(null, "Glasha"));
            repository.save(new Contact(null, "Vova"));
            repository.save(new Contact(null, "Bora"));
            repository.save(new Contact(null, "Artur"));
        };
    } 
}
