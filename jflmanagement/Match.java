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
public class Match implements Serializable {

    private Team homeTeam;
    private Team awayTeam;
    private Team winner;
    private Boolean draw = false;
    private Referee ref;
    private int homeScore;
    private int awayScore;
    private int week;
    private ArrayList<Player> goals = new ArrayList();
    private ArrayList<Player> assists = new ArrayList();
    private ArrayList<Player> yellowCards = new ArrayList();
    private ArrayList<Player> redCards = new ArrayList();

    /**
     * Constructor for the match class, finds out if there is a winner or if it
     * is a draw, increases the players goals, assits and yellow cards where
     * relevant.
     *
     * @param homeTeam Team
     * @param awayTeam Team
     * @param Ref Referee
     * @param homeScore int
     * @param awayScore int
     * @param week int
     * @param goals ArrayList Players
     * @param assists ArrayList Players
     * @param yellowCards ArrayList Players
     * @param redCards ArrayList Players
     */
    public Match(Team homeTeam, Team awayTeam, Referee Ref, int homeScore, int awayScore, int week, ArrayList<Player> goals, ArrayList<Player> assists, ArrayList<Player> yellowCards, ArrayList<Player> redCards) {
        this.homeTeam = new Team(homeTeam.getTeamName());
        this.awayTeam = new Team(awayTeam.getTeamName());
        for (int i = 0; i < homeTeam.getTeamSize(); i++) {
            this.homeTeam.addPlayer(homeTeam.getPlayer(i));
        }
        for (int i = 0; i < awayTeam.getTeamSize(); i++) {
            this.awayTeam.addPlayer(awayTeam.getPlayer(i));
        }
        this.ref = Ref;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.week = week;
        if (homeScore > awayScore) {
            winner = homeTeam;
            homeTeam.increaseGoals(homeScore);
            awayTeam.increaseGoals(awayScore);
            homeTeam.win();
            awayTeam.loss();
        } else if (homeScore == awayScore) {
            draw = true;
            homeTeam.draw();
            awayTeam.draw();
            homeTeam.increaseGoals(homeScore);
            awayTeam.increaseGoals(awayScore);
        } else {
            winner = awayTeam;
            homeTeam.increaseGoals(homeScore);
            awayTeam.increaseGoals(awayScore);
            homeTeam.loss();
            awayTeam.win();
        }
        for (int i = 0; i < goals.size(); i++) {
            this.goals.add(goals.get(i));
            this.goals.get(i).increaseGoals();
        }
        for (int i = 0; i < assists.size(); i++) {
            this.assists.add(assists.get(i));
            this.assists.get(i).increaseAssists();
        }
        for (int i = 0; i < yellowCards.size(); i++) {
            this.yellowCards.add(yellowCards.get(i));
            this.yellowCards.get(i).increaseYellowCards();
        }
        for (int i = 0; i < redCards.size(); i++) {
            this.redCards.add(redCards.get(i));
            this.redCards.get(i).increaseRedCards();
        }
    }

    /**
     * Returns the name of winner of the match
     *
     * @return String
     */
    public String getWinner() {
        return winner.getTeamName();
    }

    /**
     * Returns the home team
     *
     * @return Team
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * Returns the away team
     *
     * @return Team
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * Returns the home score
     *
     * @return int
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * Returns the away score
     *
     * @return int
     */
    public int getAwayScore() {
        return awayScore;
    }

    /**
     * Returns the amount of players that scored a goal
     *
     * @return int
     */
    public int goalsSize() {
        return goals.size();
    }

    /**
     * Returns the amount of players that had an assist
     *
     * @return int
     */
    public int assistsSize() {
        return assists.size();
    }

    /**
     * Returns the amount of players that had a yellow card
     *
     * @return int
     */
    public int yellowCardsSize() {
        return yellowCards.size();
    }

    /**
     * Returns the amount of players that had a red card
     *
     * @return int
     */
    public int redCardsSize() {
        return redCards.size();
    }

    /**
     * Returns the player that scored the goal in the specified position, in
     * order that they were scored in during the match
     *
     * @param i int
     * @return Player
     */
    public Player getGoal(int i) {
        return goals.get(i);
    }

    /**
     * Returns the player who had an assist in the specified position, in the
     * order that they happened during the match
     *
     * @param i int
     * @return Player
     */
    public Player getAssists(int i) {
        return assists.get(i);
    }

    /**
     * Returns the player who had the yellow card in the specified position, in
     * the order that they happened during the match
     *
     * @param i int
     * @return Player
     */
    public Player getYellowCards(int i) {
        return yellowCards.get(i);
    }

    /**
     * Returns the player who got a red card in the specified position, in the
     * order that they happened during the match
     *
     * @param i int
     * @return Player
     */
    public Player getRedCards(int i) {
        return redCards.get(i);
    }

    /**
     * Returns the week that the match happened on
     *
     * @return int
     */
    public int getWeek() {
        return week;
    }

}
