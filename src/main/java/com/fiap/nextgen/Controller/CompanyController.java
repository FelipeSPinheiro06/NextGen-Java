package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.nextgen.DTO.CompanyRequest;
import com.fiap.nextgen.Model.Company;
import com.fiap.nextgen.Service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "companies")
@CacheConfig(cacheNames = "companies")
@Tag(name = "Company")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @Operation(
        summary = "Listar empresas",
        description = "Retorna um array com todas as empresas e seus atributos"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Empresa retornada com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public List<Company> getMethod() {
        log.info("Pegando as empresas...");
        return companyService.getAllCompanies();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Cadastrar empresa",
        description = "Cadastro de uma empresa com o corpo de uma requisição"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Empresacadastrada com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique os dados enviados no corpo da requisição"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public Company postMethod(@RequestBody @Valid CompanyRequest companyRequest) {
        log.info("Cadastrando uma empresa...");
        return companyService.createCompany(companyRequest);
    }
    
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Atualizar empresa",
        description = "Atualiza os dados da empresa com o id informado na path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Empresa atualizada com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique os dados enviados no corpo da requisição"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login"),
        @ApiResponse(responseCode = "404", description = "Não existe empresa com o `id` informado")
    })
    public Company putMethod(@PathVariable Long id, @RequestBody @Valid CompanyRequest companyRequest) {
        log.info("Atualizando a empresa com o id " + id);
        return companyService.updateCompany(id, companyRequest);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Apagar empresa",
        description = "Apaga a empresa com o id informado no parâmetro de path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Empresa apagada com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login")
    })
    public void deleteMethod(@PathVariable @Valid Long id) {
        log.info("Deletando a empresa");
        companyService.deleteCompany(id);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Pegar empresa pelo id",
        description = "Retorna os dados da empresa com o id informado no parâmetro de path"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Empresa retornada com sucesso!"),
        @ApiResponse(responseCode = "401", description = "Não autorizado. Realize a autenticação em /login"),
        @ApiResponse(responseCode = "404", description = "Não existe empresa com o `id` informado")
    })
    public Company getByID(@PathVariable Long id) {
        log.info("Pegando a empresa com o id " + id);
        return companyService.getCompanyById(id);
    }
}
