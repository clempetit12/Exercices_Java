package org.example.classes;

public class SalaryAdjuster implements EmployeeVisitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Evalue le salaire du developpeur " + developer.getFirstname());
        int newSalaire = developer.getSalaire() + 1000;
        developer.setSalaire(newSalaire);
        System.out.println("Le noveau salaire est de " + developer.getSalaire());


    }

    @Override
    public void visit(Designer designer) {
        System.out.println("Evalue le salaire du designer " + designer.getFirstname());
        int newSalaire = designer.getSalaire() + 1000;
        designer.setSalaire(newSalaire);
        System.out.println("Le noveau salaire est de " + designer.getSalaire());



    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Evalue le salaire du manager " + manager.getFirstname());
        int newSalaire = manager.getSalaire() + 1000;
        manager.setSalaire(newSalaire);
        System.out.println("Le noveau salaire est de " + manager.getSalaire());



    }
}
