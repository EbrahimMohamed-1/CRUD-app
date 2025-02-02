package com.crudApp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    @Autowired
    SessionFactory sessionFactory;
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}