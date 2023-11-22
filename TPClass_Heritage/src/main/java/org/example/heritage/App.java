package org.example.heritage;

public class App {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.sayHello();
        Student student1 = new Student(15);
        student1.sayHello();
        student1.goToClasses();
        student1.displayAge();
        Teacher teacher1 = new Teacher();
        teacher1.setAge(40);
        teacher1.sayHello();
        teacher1.explain();

    }
}
