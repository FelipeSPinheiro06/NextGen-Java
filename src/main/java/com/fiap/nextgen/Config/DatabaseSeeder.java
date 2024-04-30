package com.fiap.nextgen.Config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fiap.nextgen.Model.Users;
import com.fiap.nextgen.Repository.CompanyRepository;
import com.fiap.nextgen.Repository.FeedbackRepository;
import com.fiap.nextgen.Repository.UserRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    // TODO: Corrigir erro do Builder

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(
            List.of(
                Users.builder().id(1L).name("Felipe").registrationDate(LocalDate.now().minusYears(2)).isSatisfied(true).gender("Masculine").aged(false).timeOfService(BigDecimal.valueOf(12)).exitForecast(LocalDate.now().plusYears(2)).build(),
                Users.builder().id(2L).name("Gabriel").registrationDate(LocalDate.now().minusMonths(3)).isSatisfied(false).gender("Masculine").aged(false).timeOfService(BigDecimal.valueOf(15)).exitForecast(LocalDate.now().plusYears(3)).build(),
                Users.builder().id(3L).name("Gustavo").registrationDate(LocalDate.now().minusWeeks(3)).isSatisfied(true).gender("Masculine").aged(false).timeOfService(BigDecimal.valueOf(17)).exitForecast(LocalDate.now().plusYears(4)).build()
            )
        );



    }


}