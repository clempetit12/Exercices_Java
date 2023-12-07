package org.example.classes;

public class SalaryAdjuster implements EmployeeVisitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Evalue le salaire du developpeur " + developer);

    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Evalue le salaire du designer " + designer);

    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Evalue le salaire du manager " + manager);

    }
}
