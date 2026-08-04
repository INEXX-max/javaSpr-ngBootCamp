package com.inexxinteractive.northwind.core.utilits.results;

public class SucessDataResult <T> extends DataResults{
    public SucessDataResult(T data,String message){
        super (data,true ,message);

    }
    public SucessDataResult(T data){
        super (data,true );

    }
}
