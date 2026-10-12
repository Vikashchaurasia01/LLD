package com.lld.splitwise.seeders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component 
@AllArgsConstructor 
public class UserDataSeeder implements CommandLineRunner {
    
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if(userRepository.count() == 0) {
            System.out.println("Seeding user data...");

            List<User> users = List.of(
                User.builder().name("Vikash").phone("1234567890").password("password1").build(),
                User.builder().name("John").phone("0987654321").password("password2").build(),
                User.builder().name("Alice").phone("1112223333").password("password3").build()
            );

            userRepository.saveAll(users);
            System.out.println("User data seeded successfully.");
        } else {
            System.out.println("User data already exists. Skipping seeding.");
        }
    }


}
