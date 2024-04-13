package com.fiap.nextgen.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fiap.nextgen.Validation.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @NotNull
    @Size(min = 3, max = 64)
    public String name;

    @NotNull
    @PastOrPresent
    public LocalDate registrationDate;
    
    @NotNull
    public boolean isSatisfied;
    
    @Genero
    public String gender;
    
    @NotNull
    public boolean aged;
    
    @Min(1)
    @NotNull
    public BigDecimal timeOfService;
    
    @NotNull
    @FutureOrPresent
    public LocalDate exitForecast;
}