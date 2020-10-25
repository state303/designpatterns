package io.dsub.structural.adapter.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
    List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        Employee employeeFromDB = new EmployeeDB("chewie", "Solo", "Han", "han@solo.com");
        employees.add(employeeFromDB);

        // will not work! this is where the adapter comes into play!
        // Employee employeeFromLdap = new EmployeeLdap("chewie", "Solo", "Han", "han@solo.com");

        EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie", "Solo", "Han", "han@solo.com");
        employees.add(new EmployeeAdapterLdap(employeeFromLdap));

        EmployeeCSV employeeFromCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@holmes.com");
        employees.add(new EmployeeAdapterCSV(employeeFromCSV));
        return employees;
    }
}
