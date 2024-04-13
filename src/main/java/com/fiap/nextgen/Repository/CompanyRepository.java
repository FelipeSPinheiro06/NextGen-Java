package com.fiap.nextgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.nextgen.Model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
     
}
