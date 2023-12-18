package org.example.classes;

public interface EmployeeVisitor {

    void visit(Developer developer);
    void visit(Designer designer);
    void visit(Manager manager);
}
