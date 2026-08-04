package com.inexxinteractive.northwind.core.utilits.results;

public class DataResults <T> extends Results {
    private T data ;
public DataResults (T data ,boolean succsess,String message){
    super(succsess,message);
    this.data=data;


}


    public DataResults (T data ,boolean succsess){
        super(succsess);
        this.data=data;


    }
    public T getData(){
    return  data;
    }




}
