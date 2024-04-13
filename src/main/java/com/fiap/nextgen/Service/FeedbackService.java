package com.fiap.nextgen.Service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.nextgen.DTO.FeedbackRequest;
import com.fiap.nextgen.Model.Feedback;
import com.fiap.nextgen.Repository.FeedbackRepository;

@Service
public class FeedbackService {
    
    FeedbackRepository feedRepository;

    public FeedbackService(FeedbackRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<Feedback> getAllFeedbacks() {
        return feedRepository.findAll();
    }

    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = constructFeedback(feedbackRequest);
        return feedRepository.save(feedback);
    }

    public Feedback updateFeedback(Long id, FeedbackRequest feedbackRequest) {
        Feedback feedback = constructFeedback(feedbackRequest);
        checkExistence(id);
        feedback.setId(id);
        return feedRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedRepository.deleteById(id);
    }

    public Feedback getFeedbackByID(Long id) {
        return checkExistence(id);
    }

    public Feedback checkExistence(Long id) {
        return feedRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe um usuário com este ID"));
    }

    public Feedback constructFeedback(FeedbackRequest feedback) {
        return new Feedback(feedback.id(),
                            feedback.feeling(), 
                            feedback.date(),
                            feedback.company());
    }
}
