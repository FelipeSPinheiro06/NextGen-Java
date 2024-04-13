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

import com.fiap.nextgen.DTO.UserRequest;
import com.fiap.nextgen.Model.Users;
import com.fiap.nextgen.Service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getMethod() {
        log.info("Pegando os usuários...");
        return userService.GrabAllUsers();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Users postMethod(@RequestBody @Valid UserRequest user) {
        log.info("Cadastrando o usuário...");
        return userService.createUser(user);
    }

    @PutMapping("{id}")
    public Users putMethod(@PathVariable Long id, @RequestBody @Valid UserRequest user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMethod(@PathVariable @Valid Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("{id}")
    public Users getByID(@PathVariable Long id) {
        return userService.GrabUserByID(id);
    }
}
