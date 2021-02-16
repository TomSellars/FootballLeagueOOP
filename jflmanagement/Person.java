/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jflmanagement;

import java.io.Serializable;

/**
 *
 * @author Tom
 */
public abstract class Person implements Serializable {

    String firstName;
    String lastName;
    int age;

    /**
     * Constructor for the Person class
     *
     * @param firstName String
     * @param lastName String
     * @param age int
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Returns the First name
     *
     * @return First Name
     */
    public String getFName() {
        return firstName;
    }

    /**
     * Returns the last name
     *
     * @return Last Name
     */
    public String getLName() {
        return lastName;
    }

    /**
     * Returns the Age
     *
     * @return Age
     */
    public int getAge() {
        return age;
    }

}
