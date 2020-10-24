package io.dsub.creational.factory.example;

public class Blog extends Website {
    /**
     * now the parent doesn't have to know anything about the details
     */
    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CartPage());
        pages.add(new ContactPage());
    }
}
