package com.inexxinteractive.northwind.core.utilits.results;

public class Results {
    private boolean success;
    private String message;



    public Results (boolean success){
        this.success=success;

    }
    public Results (boolean success,String message){
        this.success=success;
        this.message=message;

    }

    public String getMessage () {
        return  message;}

    public boolean isSuccess(){
        return  success;
    }

}
