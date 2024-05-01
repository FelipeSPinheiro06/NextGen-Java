package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.nextgen.DTO.CompanyRequest;
import com.fiap.nextgen.Model.Company;
import com.fiap.nextgen.Service.CompanyService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "companies")
@CacheConfig(cacheNames = "companies")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getMethod() {
        log.info("Pegando as empresas...");
        return companyService.getAllCompanies();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @CacheEvict(allEntries = true)
    public Company postMethod(@RequestBody @Valid CompanyRequest companyRequest) {
        log.info("Cadastrando uma empresa...");
        return companyService.createCompany(companyRequest);
    }
    
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public Company putMethod(@PathVariable Long id, @RequestBody @Valid CompanyRequest companyRequest) {
        log.info("Atualizando a empresa com o id " + id);
        return companyService.updateCompany(id, companyRequest);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    public void deleteMethod(@PathVariable @Valid Long id) {
        log.info("Deletando a empresa");
        companyService.deleteCompany(id);
    }

    @GetMapping("{id}")
    public Company getByID(@PathVariable Long id) {
        log.info("Pegando a empresa com o id " + id);
        return companyService.getCompanyById(id);
    }
}
