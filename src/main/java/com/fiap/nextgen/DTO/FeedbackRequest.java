package com.fiap.nextgen.DTO;

import java.time.LocalDate;

import com.fiap.nextgen.Model.Company;
import com.fiap.nextgen.Model.DicionarioSentimentos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record FeedbackRequest(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,

    @NotNull
    DicionarioSentimentos feeling,

    @NotNull
    @PastOrPresent
    LocalDate date,

    @NotNull
    Company company


) {}
