package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.nextgen.DTO.FeedbackRequest;
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
    public List<Feedback> getMethod(
        @RequestParam(required = false) String company,
        @RequestParam(required = false) Integer mes,
        @PageableDefault(size = 5, sort = "date", direction = Direction.DESC) Pageable pageable
    ) {
        log.info("Pegando os feedbacks...");
        return feedbackService.getAllFeedbacks(company, mes, pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Feedback postMethod(@RequestBody @Valid FeedbackRequest feedback) {
        log.info("Cadastrando o feedback...");
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("{id}")
    public Feedback putMethod(@PathVariable Long id, @RequestBody @Valid FeedbackRequest feedback) {
        log.info("Atualizando o feedback com o id " + id);
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMethod(@PathVariable @Valid Long id) {
        log.info("Deletando o feedback com o id " + id);
        feedbackService.deleteFeedback(id);
    }

    @GetMapping("{id}")
    public Feedback getByID(@PathVariable Long id) {
        log.info("Pegando o feedback com o id " + id);
        return feedbackService.getFeedbackByID(id);
    }
}
