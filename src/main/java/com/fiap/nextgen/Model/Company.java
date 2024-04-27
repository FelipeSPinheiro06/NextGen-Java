package com.fiap.nextgen.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @Size(min = 3, max = 64)
    public String name;

    @NotNull
    @PastOrPresent
    public LocalDate registrationDate;

    @NotNull
    @PositiveOrZero
    public int numberOfFeedbacks;

    @NotNull
    public String branch;
}
