package io.dsub.creational.factory.example;

import java.util.ArrayList;
import java.util.List;

/**
 * crux of the factory method pattern
 */

public abstract class Website {

    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    }

    public List<Page> getPages() {
        return pages;
    }

    public abstract void createWebsite();
}
