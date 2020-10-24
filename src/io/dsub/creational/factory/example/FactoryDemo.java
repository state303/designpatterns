package io.dsub.creational.factory.example;

public class FactoryDemo {
    public static void main(String[] args) {
        Website website = WebsiteFactory.getWebsite(SiteType.BLOG);
        System.out.println(website.getPages());

        website = WebsiteFactory.getWebsite(SiteType.SHOP);
        System.out.println(website.getPages());
    }
}
