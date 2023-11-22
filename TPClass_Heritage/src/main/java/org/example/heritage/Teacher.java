package org.example.heritage;

public class Teacher extends Person {

    private String subject;

    public Teacher() {
    }

    public Teacher(int age, String subject) {
        super(age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void explain() {
        System.out.println("Explanation begins.");
    }
}
