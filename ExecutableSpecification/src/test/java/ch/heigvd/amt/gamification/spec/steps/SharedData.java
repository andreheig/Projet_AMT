package ch.heigvd.amt.gamification.spec.steps;

import com.github.javafaker.Faker;

public class SharedData {
    private int statusCode;
    private Faker faker;
    private int counter = 1;

    public Faker getFaker(){
        return new Faker();
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public void setStatusCode(int code){
        this.statusCode = code;
    }

    public int getCounter(){
        return this.counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

}
