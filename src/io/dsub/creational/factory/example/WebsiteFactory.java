package io.dsub.creational.factory.example;

public class WebsiteFactory {
    public static Website getWebsite(SiteType type) {
        Website site;
        switch (type) {
            case BLOG -> site = new Blog();
            case SHOP -> site = new Shop();
            default -> site = null;
        }
        return site;
    }
}
