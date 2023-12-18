package org.example;

import org.example.classes.*;

public class Main {
    public static void main(String[] args) {
        Designer designer = new Designer("Hélène", "Patard",2000);
        Developer developer = new Developer("Olivia", "Pigani",1000);
        Manager manager = new Manager("Pauline", "Laout",4000);


        System.out.println(designer.getFirstname());
        designer.accept(new PerformanceEvaluateur());
        developer.accept(new PerformanceEvaluateur());

        designer.accept(new SalaryAdjuster());
        manager.accept(new SalaryAdjuster());
developer.accept(new SalaryAdjuster());


    }
}