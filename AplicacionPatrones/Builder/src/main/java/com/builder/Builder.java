package com.builder;

import builder.dto.Employee;

public class Builder {
    public static void main(String[] args) {
        Employee emp = new Employee.EmployeeBuilder()
            .setName("Yuberley Guerrero Castro")
            .setGender("Male")
            .setAge(29)
            .setAdress("Apartamento 189 int 404 Álamos " + "Villavicencio", "Colombia", "Colombia", "03400")
            .addContacs("Rene Blancarte", "1122334455", "123", "Casa", "Chapultepect No. 123 Col. Militar", "México", "México", "10023")
            .addContacs("Jaime Blancarte", "3344556677", null, "Celular")
            .addPhones("4567890234", null, "Celular")
            .addPhones("7788990099", null, "Casa")
            .build();

        System.out.println(
                emp.toString()
        );
    }
}
