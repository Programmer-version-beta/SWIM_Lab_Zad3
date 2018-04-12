package com.example.fabian.swim_lab_zad3;


class Actor {

    private String name;
    private String surname;
    private int age;

    Actor(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    String getName(){
        return name;
    }

    String getSurname(){
        return surname;
    }

    String getAge(){
        return String.valueOf(age);
    }
}
