package io.dsub.structural.proxy;

public interface TwitterService {
    String getTimeline(String screenName) throws RuntimeException;
    void postToTimeline(String screenName, String message);
}
