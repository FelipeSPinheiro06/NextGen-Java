package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.nextgen.DTO.FrasesRequest;
import com.fiap.nextgen.Model.Frases;
import com.fiap.nextgen.Service.FrasesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@Slf4j
@RequestMapping("frases")
public class FrasesController {
    
    @Autowired
    FrasesService frasesService;

    @GetMapping()
    public List<Frases> getFrases() {
        log.info("Pegando todas as frases");
        return frasesService.getAll();
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    public Frases postFrase(@RequestBody FrasesRequest fraseRequest) {
        log.info("Postando um texto");
        return frasesService.create(fraseRequest);
    }
    
    @PutMapping("{id}")
    public Frases put(@PathVariable Long id, @RequestBody FrasesRequest frasesRequest) {
        log.info("Atualizando  as frases");
        return frasesService.atualizar(id, frasesRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.info("Apagando as frases criadas");
        frasesService.delete(id);
    }

    @GetMapping("{id}")
    public Frases getFrasesByID(@PathVariable Long id) {
        log.info("Pegando a frase com o id " + id);
        return frasesService.getFrasesById(id);
    }
    
}
