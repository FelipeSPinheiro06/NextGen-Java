package com.fiap.nextgen.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fiap.nextgen.Validation.Genero;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record UserRequest(
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,

    @NotBlank
    @Size(min = 3, max = 64)
    String name,

    @NotNull
    @PastOrPresent
    LocalDate registrationDate,
    
    @NotNull
    boolean isSatisfied,
    
    @Genero
    String gender,
    
    @NotNull
    boolean aged,
    
    @Min(1)
    @NotNull
    BigDecimal timeOfService,
    
    @NotNull
    @FutureOrPresent
    LocalDate exitForecast

){}
