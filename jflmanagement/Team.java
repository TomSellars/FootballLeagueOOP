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
public class Team implements Serializable {

    private ArrayList<Player> myTeam = new ArrayList();
    private String teamName;
    private Coach teamCoach;
    private Boolean hasCoach = false;
    private int wins = 0;
    private int draws = 0;
    private int losses = 0;
    private int totalGoals = 0;
    private int points = 0;

    /**
     * Constructor for the Team class
     *
     * @param teamName String
     */
    public Team(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Returns the Team name
     *
     * @return String
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Set the team name
     *
     * @param TeamName String
     */
    public void setTeamName(String TeamName) {
        this.teamName = TeamName;
    }

    /**
     * Add a player to the team
     *
     * @param player Player
     */
    public void addPlayer(Player player) {
        myTeam.add(player);
    }

    /**
     * Remove a player from a team
     *
     * @param player Player
     */
    public void removePlayer(Player player) {
        myTeam.remove(player);
    }

    /**
     * Returns the size of the team
     *
     * @return int
     */
    public int getTeamSize() {
        return myTeam.size();
    }

    /**
     * Returns the player at the specified position on the team
     *
     * @param i int
     * @return Player
     */
    public Player getPlayer(int i) {
        try {
            return myTeam.get(i);
        } catch (IndexOutOfBoundsException I) {
            I.printStackTrace();
            return null;
        }

    }

    /**
     * Adds a coach to the team
     *
     * @param coach Coach
     */
    public void addCoach(Coach coach) {
        teamCoach = coach;
        hasCoach = true;
    }

    /**
     * Removes a coach from the team
     */
    public void removeCoach() {
        teamCoach = null;
        hasCoach = false;
    }

    /**
     * Returns true if the team has a coach
     *
     * @return Boolean
     */
    public boolean hasCoach() {
        return hasCoach;
    }

    /**
     * Returns the coach on a team
     *
     * @return Coach
     */
    public Coach getCoach() {
        return teamCoach;
    }

    /**
     * Returns the wins of the Team
     *
     * @return int
     */
    public int getWins() {
        return wins;
    }

    /**
     * Adds a win to the team and increments the points by three
     */
    public void win() {
        wins = wins + 1;
        points = points + 3;
    }

    /**
     * Returns the Draws for the team
     *
     * @return int
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Adds a draw to the team and increments the points by one
     */
    public void draw() {
        draws = draws + 1;
        points = points + 1;
    }

    /**
     * Returns the losses of the team
     *
     * @return int
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Increments the losses
     */
    public void loss() {
        losses = losses + 1;
    }

    /**
     * Returns the total goals of the team
     *
     * @return int
     */
    public int getTotalGoals() {
        return totalGoals;
    }

    /**
     * Set the total goals of a team to the specified amount
     *
     * @param i int
     */
    public void setTotalGoals(int i) {
        totalGoals = i;
    }

    /**
     * Increase the total goals by the amount specified
     *
     * @param i int
     */
    public void increaseGoals(int i) {
        totalGoals = totalGoals + i;
    }

    /**
     * Returns the total points of the team
     *
     * @return int
     */
    public int getPoints() {
        return points;
    }

}
