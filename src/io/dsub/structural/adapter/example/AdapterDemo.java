package io.dsub.structural.adapter.example;

import java.util.List;

public class AdapterDemo {
    public static void main(String[] args) {

        // from users perspective, we are just getting a list then prints it out.
        EmployeeClient client = new EmployeeClient();
        List<Employee> employees = client.getEmployeeList();
        System.out.println(employees);
    }
}
