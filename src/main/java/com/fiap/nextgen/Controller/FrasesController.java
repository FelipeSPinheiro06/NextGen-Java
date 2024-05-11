package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.nextgen.DTO.FrasesRequest;
import com.fiap.nextgen.Model.Frases;
import com.fiap.nextgen.Service.FrasesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
@RequestMapping("frases")
@Tag(name = "Frases")
public class FrasesController {
    
    @Autowired
    FrasesService frasesService;

    @GetMapping()
    @Operation(
        summary = "Listar frases",
        description = "Retorna um array com todas as frases dos feedbacks"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Frase retornada com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public List<Frases> getFrases() {
        log.info("Pegando todas as frases");
        return frasesService.getAll();
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar bloco de frases",
        description = "Cadastro de frases com o corpo de uma requisição"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Frase cadastrada com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique os dados enviados no corpo da requisição"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public Frases postFrase(@RequestBody FrasesRequest fraseRequest) {
        log.info("Postando um texto");
        return frasesService.create(fraseRequest);
    }
    
    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar bloco de frases",
        description = "Atualiza os dados da frase com o id informado na path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Frase atualizada com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique os dados enviados no corpo da requisição"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login"),
        @ApiResponse(responseCode = "404", description = "Não existe bloco de frases com o `id` informado")
    })
    public Frases put(@PathVariable Long id, @RequestBody FrasesRequest frasesRequest) {
        log.info("Atualizando  as frases");
        return frasesService.atualizar(id, frasesRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
        summary = "Apagar bloco de frases",
        description = "Apaga a frase com o id informado no parâmetro de path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Frase apagada com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public void delete(@PathVariable Long id) {
        log.info("Apagando as frases criadas");
        frasesService.delete(id);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Pegar bloco de frases pelo id",
        description = "Retorna os dados da frase com o id informado no parâmetro de path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Frase retornada com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login"),
        @ApiResponse(responseCode = "404", description = "Não existe frase com o `id` informado")
    })
    public Frases getFrasesByID(@PathVariable Long id) {
        log.info("Pegando a frase com o id " + id);
        return frasesService.getFrasesById(id);
    }
    
}
