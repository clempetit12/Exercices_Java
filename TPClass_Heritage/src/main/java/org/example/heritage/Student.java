package org.example.heritage;

public class Student extends Person {

    public Student(int age) {
        super(age);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int n) {
        super.setAge(n);
    }

    public void goToClasses() {
    System.out.println("I'm going to class.");
}
    public void displayAge() {
        System.out.println("My age is: " + getAge() + " years old .");

    }

}
