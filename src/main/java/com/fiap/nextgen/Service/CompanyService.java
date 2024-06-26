package com.fiap.nextgen.Service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.nextgen.DTO.CompanyRequest;
import com.fiap.nextgen.Model.Company;
import com.fiap.nextgen.Repository.CompanyRepository;

@Service
public class CompanyService {
    
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company createCompany(CompanyRequest companyRequest) {
        Company company = constructCompany(companyRequest);
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = constructCompany(companyRequest);
        checkExistence(id);
        company.setId(id);
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company getCompanyById(Long id) {
        return checkExistence(id);
    }

    public Company checkExistence(Long id) {
        return companyRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe um usuário com este ID"));
    }

    public Company constructCompany(CompanyRequest companyRequest) {
        return new Company(companyRequest.id(), 
                            companyRequest.name(), 
                            companyRequest.registrationDate(), 
                            companyRequest.numberOfFeedbacks(), 
                            companyRequest.branch());
    }
}
