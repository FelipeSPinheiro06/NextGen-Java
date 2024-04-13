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

import com.fiap.nextgen.Model.Company;
import com.fiap.nextgen.Repository.CompanyRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "companies")
public class CompanyController {
    
    @Autowired
    CompanyRepository companyRepository;

    
    @GetMapping
    public List<Company> getMethod() {
        log.info("Pegando as empresas...");
        return companyRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Company postMethod(@RequestBody @Valid Company company) {
        log.info("Cadastrando uma empresa...");
        return companyRepository.save(company);
    }

    @PutMapping("{id}")
    public Company putMethod(@PathVariable Long id, @RequestBody @Valid Company company) {
        checkExistence(id);
        company.setId(id);
        return companyRepository.save(company);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMethod(@PathVariable @Valid Long id) {
        companyRepository.deleteById(id);
    }

    @GetMapping("{id}")
    public Company getByID(@PathVariable Long id) {
        return checkExistence(id);
    }
    
    public Company checkExistence(Long id) {
        return companyRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe uma empresa com este ID"));
    }
}
