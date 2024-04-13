package com.fiap.nextgen.Controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
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
import org.springframework.web.server.ResponseStatusException;

import com.fiap.nextgen.Model.Users;
import com.fiap.nextgen.Repository.UserRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "users")
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    
    @GetMapping
    public List<Users> getMethod() {
        log.info("Pegando os usuários...");
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Users postMethod(@RequestBody @Valid Users user) {
        log.info("Cadastrando o usuário...");
        return userRepository.save(user);
    }

    @PutMapping("{id}")
    public Users putMethod(@PathVariable Long id, @RequestBody @Valid Users user) {
        checkExistence(id);
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMethod(@PathVariable @Valid Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("{id}")
    public Users getByID(@PathVariable Long id) {
        return checkExistence(id);
    }
    
    public Users checkExistence(Long id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe um usuário com este ID"));
    }
}
