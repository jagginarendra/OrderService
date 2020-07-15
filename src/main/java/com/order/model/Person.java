package com.order.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {

    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    private String id;

    private String name;

    private String department;

    private String designation;

    public Person(String id, String name, String department, String designation) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    public Person() {
       // logger.info("def cons()");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
