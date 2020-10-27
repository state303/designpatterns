package io.dsub.behavioral.chainofresponsibility.example;

public class Request {

    private RequestType requestType;
    private double amount;

    public Request(RequestType requestType, double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public double getAmount() {
        return this.amount;
    }
}
