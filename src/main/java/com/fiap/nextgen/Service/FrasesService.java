package com.fiap.nextgen.Service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.nextgen.DTO.FrasesRequest;
import com.fiap.nextgen.Model.Frases;
import com.fiap.nextgen.Repository.FrasesRepository;

@Service
public class FrasesService {

    @Autowired
    FrasesRepository frasesRepository;

    public List<Frases> getAll() {
        return frasesRepository.findAll();
    }

    public Frases create(FrasesRequest fraseRequest) {
        Frases frase = constructFrases(fraseRequest);
        return frasesRepository.save(frase);
    }

    public Frases atualizar(Long id, FrasesRequest fraseRequest) {
        Frases frases = constructFrases(fraseRequest);
        checkExistence(id);
        frases.setId(id);
        return frasesRepository.save(frases);
    }

    public void delete(Long id) {
        frasesRepository.deleteById(id);
    }


    public Frases checkExistence(Long id) {
        return frasesRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe um usuário com este ID"));
    }

    public Frases constructFrases(FrasesRequest frasesRequest) {
        return new Frases(
            frasesRequest.id(),
            frasesRequest.frase()
        );
    }

}
