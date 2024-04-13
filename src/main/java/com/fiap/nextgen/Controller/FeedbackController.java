package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.nextgen.Model.Feedback;
import com.fiap.nextgen.Repository.FeedbackRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "feedbacks")
public class FeedbackController {
    
    @Autowired
    FeedbackRepository feedRepository;

    
    @GetMapping
    public List<Feedback> getMethod() {
        log.info("Pegando os feedbacks...");
        return feedRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Feedback postMethod(@RequestBody @Valid Feedback feedback) {
        log.info("Cadastrando o feedback...");
        return feedRepository.save(feedback);
    }

    @PutMapping("{id}")
    public Feedback putMethod(@PathVariable Long id, @RequestBody @Valid Feedback feedback) {
        checkExistence(id);
        feedback.setId(id);
        return feedRepository.save(feedback);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMethod(@PathVariable @Valid Long id) {
        feedRepository.deleteById(id);
    }

    @GetMapping("{id}")
    public Feedback getByID(@PathVariable Long id) {
        return checkExistence(id);
    }
    
    public Feedback checkExistence(Long id) {
        return feedRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe um feedback com este ID"));
    }
}
