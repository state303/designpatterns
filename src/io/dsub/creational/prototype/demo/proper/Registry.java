package io.dsub.creational.prototype.demo.proper;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String, Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }

    // here we are using a straight string, but it is highly recommended to use an enum
    public Item createItem(String type) {
        Item item = null;

        try {
            item = (Item)(items.get(type).clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return item;
    }

    // load basic stuffs
    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        items.put("Movie", movie);

        Book book = new Book();
        book.setNumberOfPage(335);
        book.setPrice(19.99);
        book.setTitle("Basic book");
        items.put("Book", book);
    }
}
