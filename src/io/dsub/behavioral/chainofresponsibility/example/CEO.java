package io.dsub.behavioral.chainofresponsibility.example;

public class CEO extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.PURCHASE) {
            System.out.println("CEO can handle all purchases");
        } else {
            successor.handleRequest(request);
        }
    }
}
