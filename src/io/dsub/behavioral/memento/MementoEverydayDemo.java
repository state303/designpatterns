package io.dsub.behavioral.memento;

import io.dsub.structural.adapter.example.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MementoEverydayDemo {

    private static void serialize(Employee emp) {

        try(FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
