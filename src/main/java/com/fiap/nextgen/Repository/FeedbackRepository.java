package com.fiap.nextgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.nextgen.Model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    
}
