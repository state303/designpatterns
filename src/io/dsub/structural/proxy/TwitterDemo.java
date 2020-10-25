package io.dsub.structural.proxy;

public class TwitterDemo {
    public static void main(String[] args) {
        TwitterService service = SecurityProxy.newInstance(new TwitterServiceStub());

        try {
            String result = service.getTimeline("post");
            System.out.println(result);
        } catch (RuntimeException e) {
            System.out.println("success!!!");
        }
    }
}
