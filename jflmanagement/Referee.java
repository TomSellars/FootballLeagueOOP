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
public class Referee extends Person implements Serializable {

    String Work;

    /**
     * Constructor for the referee class
     *
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param work String
     */
    public Referee(String firstName, String lastName, int age, String work) {
        super(firstName, lastName, age);
        this.Work = work;
    }

}
