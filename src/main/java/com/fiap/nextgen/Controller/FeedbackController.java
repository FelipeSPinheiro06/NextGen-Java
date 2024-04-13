package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.nextgen.Model.Feedback;
import com.fiap.nextgen.Service.FeedbackService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "feedbacks")
public class FeedbackController {

    FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getMethod() {
        log.info("Pegando os feedbacks...");
        return feedbackService.getAllFeedbacks();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Feedback postMethod(@RequestBody @Valid Feedback feedback) {
        log.info("Cadastrando o feedback...");
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("{id}")
    public Feedback putMethod(@PathVariable Long id, @RequestBody @Valid Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMethod(@PathVariable @Valid Long id) {
        feedbackService.deleteFeedback(id);
    }

    @GetMapping("{id}")
    public Feedback getByID(@PathVariable Long id) {
        return feedbackService.getFeedbackByID(id);
    }
}
