/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jflmanagement;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Player extends Person implements Serializable {

    private String position;
    private Boolean onTeam = false;
    private int yellowCards = 0;
    private int redCards = 0;
    private int totalAssists = 0;
    private int totalGoals = 0;
    private ArrayList<Match> matches = new ArrayList();
    private String currentTeam;

    /**
     * Constructor for the player class
     *
     * @param firstName String
     * @param lastName String
     * @param age int
     * @param position String
     */
    public Player(String firstName, String lastName, int age, String position) {
        super(firstName, lastName, age);
        this.position = position;
    }

    /**
     * Returns true of if the player is on a team.
     *
     * @return Boolean
     */
    public Boolean getOnTeam() {
        return onTeam;
    }

    /**
     * Returns t he name of the current team
     *
     * @return String
     */
    public String getTeam() {
        return currentTeam;
    }

    /**
     * Set the onTeam boolean and the team name.
     *
     * @param onTeam Boolean
     * @param currentTeam String
     */
    public void setOnTeam(Boolean onTeam, String currentTeam) {
        this.onTeam = onTeam;
        this.currentTeam = currentTeam;
    }

    /**
     * Returns the position that the player plays
     *
     * @return String
     */
    public String getPosition() {
        return position;
    }

    /**
     * Increases the players yellow cards by one
     */
    public void increaseYellowCards() {
        yellowCards = yellowCards + 1;
    }

    /**
     * Increases the players red cards by one
     */
    public void increaseRedCards() {
        redCards = redCards + 1;
    }

    /**
     * Returns the total yellow cards of the player
     *
     * @return int
     */
    public int getYellowCards() {
        return yellowCards;
    }

    /**
     * Returns the total red cards of the player
     *
     * @return int
     */
    public int getRedCards() {
        return redCards;
    }

    /**
     * Increase the total assists by one
     */
    public void increaseAssists() {
        totalAssists = totalAssists + 1;
    }

    /**
     * Returns the total assists of the player
     *
     * @return int
     */
    public int getTotalAssists() {
        return totalAssists;
    }

    /**
     * Increases the total goals of the player by one
     */
    public void increaseGoals() {
        totalGoals = totalGoals + 1;
    }

    /**
     * Returns the total goals of the player
     *
     * @return int
     */
    public int getTotalGoals() {
        return totalGoals;
    }

    /**
     * Add a match to the match history
     *
     * @param match Match
     */
    public void addMatch(Match match) {
        matches.add(match);
    }

    /**
     * Returns the size of the match history
     *
     * @return int
     */
    public int matchSize() {
        return matches.size();
    }

    /**
     * Returns the match at the specified position
     *
     * @param i int
     * @return Match
     */
    public Match getMatch(int i) {
        return matches.get(i);
    }
}
