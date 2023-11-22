package org.example.heritage;

public class Person {

    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println(age + "years old");
    }

    public void sayHello(){
        System.out.println("Hello");
    }
}
