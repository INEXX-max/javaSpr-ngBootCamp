package com.inexxinteractive.northwind.core.utilits.results;

public class ErorDataResult <T> extends DataResults{
    public ErorDataResult(T data,String message){
        super (data,true ,message);

    }
    public ErorDataResult(T data){
        super (data,true );


    }
    public ErorDataResult(String message){
        super (null,true,message);
    }
    public ErorDataResult(){
        super (null,true);
    }


}
