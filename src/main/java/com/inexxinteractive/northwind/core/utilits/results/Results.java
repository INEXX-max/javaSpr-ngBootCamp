package com.inexxinteractive.northwind.core.utilits.results;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Results {
    private boolean success;
    private String message;



    public Results (boolean success){
        this.success=success;

    }



}
