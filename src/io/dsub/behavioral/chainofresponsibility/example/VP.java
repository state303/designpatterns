package io.dsub.behavioral.chainofresponsibility.example;

public class VP extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.PURCHASE) {
            if (request.getAmount() < 1500) {
                System.out.println("VP's can approve purchases below 1500");
                return;
            }
        }
        successor.handleRequest(request);
    }
}
