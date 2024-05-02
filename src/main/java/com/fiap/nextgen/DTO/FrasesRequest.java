package com.fiap.nextgen.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record FrasesRequest(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,

    @NotBlank
    String frase

) {}
