package com.inexxinteractive.northwind.api.controllers;


import com.inexxinteractive.northwind.busiess.abstracts.UserService;
import com.inexxinteractive.northwind.core.entites.User;
import com.inexxinteractive.northwind.core.utilits.results.ErorDataResult;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String,String> validationEror=new HashMap<String ,String>() ;
        for(FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            validationEror.put(fieldError.getField(),fieldError.getDefaultMessage());

        }
        ErorDataResult<Object> erors=new ErorDataResult<    Object>(validationEror,"Doğrulama hataalrı");
        return  erors;

    }


}
