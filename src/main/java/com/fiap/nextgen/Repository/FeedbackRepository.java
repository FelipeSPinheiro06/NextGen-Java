package com.fiap.nextgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.nextgen.Model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // @Query("SELECT f FROM Feedback f WHERE MONTH(f.date) = ?2 AND f.company.name = ?1 ")
    // List<Feedback> findByCompanyNameAndMes(String company, Integer mes, Pageable pageable);

    
    // List<Feedback> findByMes(Integer mes, Pageable pageable);

    // List<Feedback> findByCompany(String company, Pageable pageable);
    
}
