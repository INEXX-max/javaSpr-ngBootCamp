package com.inexxinteractive.northwind.api.controllers;

import com.inexxinteractive.northwind.busiess.abstracts.UserService;
import com.inexxinteractive.northwind.core.entites.User;
import com.inexxinteractive.northwind.core.utilits.results.ErorDataResult;

import jakarta.validation.Valid; // Doğrulama işleminin çalışması için gereken import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    // Best Practice (En İyi Uygulama): Güvenlik ve bellek yönetimi için 'final' eklendi.
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception) {

        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // Typo (Yazım hataları) ve gereksiz boşluklar düzeltildi
        return new ErorDataResult<>(validationErrors, "Doğrulama hataları");
    }
}