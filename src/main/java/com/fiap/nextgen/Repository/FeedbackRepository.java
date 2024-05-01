package com.fiap.nextgen.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiap.nextgen.Model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(" SELECT f FROM Feedback f WHERE MONTH(f.date) = ?2 AND f.company.name = ?1 ")
    List<Feedback> findByCompanyNameAndMes(String company, Integer mes, Pageable pageable);

    @Query(" SELECT f FROM Feedback f WHERE MONTH(f.date) = ?1 ")
    List<Feedback> findByMes(Integer mes, Pageable pageable);

    List<Feedback> findByCompanyName(String company, Pageable pageable);
    
}
