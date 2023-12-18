package org.example.classes;

public class PerformanceEvaluateur implements EmployeeVisitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Evalue la performance du développeur " +developer);

    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Evalue la performance du designer " +designer);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Evalue la performance du manager " +manager);
    }
}
