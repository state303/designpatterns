package io.dsub.structural.decorator;

import java.io.*;

public class EverydayExample {
    public static void main(String[] args) {

        File file = new File("./output.txt");

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            file.createNewFile();
            file.deleteOnExit();
            dataOutputStream.writeChars("hello world my dear");
            System.out.println(reader.lines().reduce((acc, curr) -> acc + curr).orElse(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
