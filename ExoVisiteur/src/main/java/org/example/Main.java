package org.example;

import org.example.classes.*;

public class Main {
    public static void main(String[] args) {
        Designer designer = new Designer("Hélène", "Patard");
        Developer developer = new Developer("Olivia", "Pigani");
        Manager manager = new Manager("Pauline", "Laout");


        System.out.println(designer.getFirstname());
        designer.accept(new PerformanceEvaluateur());
        developer.accept(new PerformanceEvaluateur());

        designer.accept(new SalaryAdjuster());
        manager.accept(new SalaryAdjuster());



    }
}