package com.fiap.nextgen.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    public String feeling;
    
    @NotNull
    @PastOrPresent
    public LocalDate date;
    
    @NotNull
    public String company;
}
