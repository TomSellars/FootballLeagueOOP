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
public class Coach extends Person implements Serializable {

    String formation;
    Boolean onTeam = false;

    /**
     * Constructor for the Coach class
     *
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param formation String
     */
    public Coach(String firstName, String lastName, int age, String formation) {
        super(firstName, lastName, age);
        this.formation = formation;
    }

    /**
     * Returns true if the coach is on a team
     *
     * @return boolean
     */
    public boolean getOnTeam() {
        return onTeam;
    }

    /**
     * Set the boolean for if the coach is on a team
     *
     * @param onTeam Boolean
     */
    public void setOnTeam(boolean onTeam) {
        this.onTeam = onTeam;
    }

}
