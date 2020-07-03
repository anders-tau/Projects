/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloapp;

/**
 *
 * @author Anders
 */
public class Person {
    String name;    // имя
    protected int age;    // возраст
    public String address;
    public String phone;

    public Person(String name, int age, String address, String phone){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;         
    }
    public void displayInfo(){
            System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
    void displayAge(){
        System.out.printf("Age: %d \n", age);
    }
    private void displayAddress(){
        System.out.printf("Address: %s \n", address);
    }
    protected void displayPhone(){
        System.out.printf("Phone: %s \n", phone);
    }    
}
