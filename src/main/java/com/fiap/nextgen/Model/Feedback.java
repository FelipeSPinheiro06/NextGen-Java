package com.fiap.nextgen.Model;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // TODO: Criar enum
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public DicionarioSentimentos feeling;
    
    @NotNull
    @PastOrPresent
    public LocalDate date;
    
    @NotNull
    @ManyToOne
    public Company company;
}
