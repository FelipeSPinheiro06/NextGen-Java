package com.fiap.nextgen.Config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fiap.nextgen.Model.Company;
import com.fiap.nextgen.Model.DicionarioSentimentos;
import com.fiap.nextgen.Model.Feedback;
import com.fiap.nextgen.Model.Frases;
import com.fiap.nextgen.Model.Users;
import com.fiap.nextgen.Repository.CompanyRepository;
import com.fiap.nextgen.Repository.FeedbackRepository;
import com.fiap.nextgen.Repository.FrasesRepository;
import com.fiap.nextgen.Repository.UserRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    FrasesRepository frasesRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(
            List.of(
                Users.builder().id(1L).name("Felipe").registrationDate(LocalDate.now().minusYears(2))
                    .isSatisfied(true).gender("Masculine").aged(false).timeOfService(BigDecimal.valueOf(12)).exitForecast(LocalDate.now().plusYears(2)).build(),
                Users.builder().id(2L).name("Gabriel").registrationDate(LocalDate.now().minusMonths(3))
                    .isSatisfied(false).gender("Masculine").aged(false).timeOfService(BigDecimal.valueOf(15)).exitForecast(LocalDate.now().plusYears(3)).build(),
                Users.builder().id(3L).name("Gustavo").registrationDate(LocalDate.now().minusWeeks(3))
                    .isSatisfied(true).gender("Masculine").aged(false).timeOfService(BigDecimal.valueOf(17)).exitForecast(LocalDate.now().plusYears(4)).build()
            )
        );

        companyRepository.saveAll(
            List.of(
                Company.builder().id(1L).name("Apple").registrationDate(LocalDate.of(1985, 4, 15))
                    .numberOfFeedbacks(BigDecimal.ZERO).branch("Omni CRM").build(),
                Company.builder().id(2L).name("Microsoft").registrationDate(LocalDate.of(1996, 9, 2))
                    .numberOfFeedbacks(BigDecimal.ONE).branch("Social").build(),
                Company.builder().id(3L).name("Samsung").registrationDate(LocalDate.of(2005, 7, 6))
                    .numberOfFeedbacks(BigDecimal.valueOf(2)).branch("AI").build()
            )
        );

        feedbackRepository.saveAll(
            List.of(
                Feedback.builder().id(1L).feeling(DicionarioSentimentos.TERRIBLE).date(LocalDate.of(2010, 12, 25)).company(companyRepository.findById(1L).get()).build(), 
                Feedback.builder().id(2L).feeling(DicionarioSentimentos.REGULAR).date(LocalDate.of(2015, 1, 2)).company(companyRepository.findById(2L).get()).build(), 
                Feedback.builder().id(3L).feeling(DicionarioSentimentos.AWESOME).date(LocalDate.of(2020, 5, 15)).company(companyRepository.findById(3L).get()).build(),
                Feedback.builder().id(4L).feeling(DicionarioSentimentos.BAD).date(LocalDate.of(2005, 7, 12)).company(companyRepository.findById(1L).get()).build(),
                Feedback.builder().id(5L).feeling(DicionarioSentimentos.GOOD).date(LocalDate.of(2012, 3, 8)).company(companyRepository.findById(2L).get()).build(),
                Feedback.builder().id(6L).feeling(DicionarioSentimentos.TERRIBLE).date(LocalDate.of(2019, 9, 20)).company(companyRepository.findById(3L).get()).build()
            )
        );

        frasesRepository.saveAll(
            List.of(
                Frases.builder().id(1L).frase("Brabo demais").build(), 
                Frases.builder().id(2L).frase("Médio").build(), 
                Frases.builder().id(3L).frase("Esse atendimento é precário").build()
            )
        );

    }


}