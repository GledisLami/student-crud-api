package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student gledis = new Student( "Gledis", "lamigledi@gmail.com", LocalDate.of(2003, Month.JANUARY, 6) );
            Student alex = new Student( "alex", "alex@gmail.com", LocalDate.of(2004, Month.JANUARY, 6));

            repository.saveAll(
                    List.of(gledis, alex)
            );
        };
    }
}
