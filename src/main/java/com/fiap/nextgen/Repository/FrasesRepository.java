package com.fiap.nextgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.nextgen.Model.Frases;

public interface FrasesRepository extends JpaRepository<Frases, Long> {
    
}
