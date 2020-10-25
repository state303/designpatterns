package io.dsub.structural.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class EverydayExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http", "app.pluralsight.com", 80, "/library");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String in = reader.lines().reduce((acc, curr) -> acc + "\n" + curr).orElse("");
        System.out.println(in);

        reader.close();
    }
}
