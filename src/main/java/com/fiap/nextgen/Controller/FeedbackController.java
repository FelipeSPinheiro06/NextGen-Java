package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "feedbacks")
@Tag(name = "Feedback")
public class FeedbackController {

    FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    @Operation(
        summary = "Listar Feedbacks",
        description = "Retorna um array com todos os atributos do feedback"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Feedback retornado com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Feedback não autorizado. Realize a autenticação em /login")
    })
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
    @Operation(
        summary = "Cadastrar feedback",
        description = "Cadastro de um feedback com o corpo de uma requisição"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Feedback cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique os dados enviados no corpo da requisição"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public Feedback postMethod(@RequestBody @Valid FeedbackRequest feedback) {
        log.info("Cadastrando o feedback...");
        return feedbackService.createFeedback(feedback);
    }
            
    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar feedback",
        description = "Atualiza os dados do feedback com o id informado na path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Feedback retornado com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique os dados enviados no corpo da requisição"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login"),
        @ApiResponse(responseCode = "404", description = "Não existe feedback com o id informado")
    })
    public Feedback putMethod(@PathVariable Long id, @RequestBody @Valid FeedbackRequest feedback) {
        log.info("Atualizando o feedback com o id " + id);
        return feedbackService.updateFeedback(id, feedback);
    }
                
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
        summary = "Apagar feedback",
        description = "Apaga o feedback com o id informado no parâmetro de path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Feedback apagado com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public void deleteMethod(@PathVariable @Valid Long id) {
        log.info("Deletando o feedback com o id " + id);
        feedbackService.deleteFeedback(id);
    }
                    
                    
    @GetMapping("{id}")
    @Operation(
        summary = "Pegar feedback pelo id",
        description = "Retorna os dados do feedback com o id informado no parâmetro de path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Feedback retornado com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login"),
        @ApiResponse(responseCode = "404", description = "Não existe feedback com o id informado")
    })
    public Feedback getByID(@PathVariable Long id) {
        log.info("Pegando o feedback com o id " + id);
        return feedbackService.getFeedbackByID(id);
    }
                        
                        
    @GetMapping("media-nota-empresa")
    @Operation(
        summary = "Lista média das notas das empresas",
        description = "Calcula e retorna a média da nota de cada empresa pelos feedbacks que contem"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Feedback retornado com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Feedback não autorizado. Realize a autenticação em /login")
    })
    public Map<String, Double> getMediaNotaEmpresa() {
        
        var feedbacks = feedbackService.getAllFeedbacks();
        
        var collect = feedbacks.stream()
        .collect(
            Collectors.groupingBy(
                f -> f.getCompany().getName(),
                Collectors.averagingDouble(f -> f.getFeeling().getFeeling())
                )
            );
                
            return collect;
        }
}
                                
                                