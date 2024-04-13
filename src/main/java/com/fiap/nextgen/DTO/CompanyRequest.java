package com.fiap.nextgen.DTO;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CompanyRequest(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,

    @NotBlank
    @Size(min = 3, max = 64)
    String name,

    @NotNull
    @PastOrPresent
    LocalDate registrationDate,

    @NotNull
    @PositiveOrZero
    int numberOfFeedbacks,

    @NotNull
    String branch

) {}
