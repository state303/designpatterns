package io.dsub.structural.adapter.example;

import java.util.StringTokenizer;

public class EmployeeCSV {

    private int id;
    private String firstname;
    private String lastname;
    private String emailAddress;

    public EmployeeCSV(String values) {
        StringTokenizer tokenizer = new StringTokenizer(values, ",");
        if (tokenizer.hasMoreTokens()) {
            id = Integer.parseInt(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            firstname = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            lastname = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            emailAddress = tokenizer.nextToken();
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
