/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jflmanagement.data;

import java.io.*;
import java.util.*;
import javax.swing.*;
import jflmanagement.Coach;
import jflmanagement.GUI.JFLGUI;
import jflmanagement.Match;
import jflmanagement.Player;
import jflmanagement.Referee;
import jflmanagement.Team;

/**
 *
 * @author Tom
 */
public class JFLManagement {

    static private ArrayList<Team> TeamArrayList = new ArrayList<Team>();
    static private ArrayList<Player> PlayerArrayList = new ArrayList<Player>();
    static private ArrayList<Coach> CoachArrayList = new ArrayList<Coach>();
    static private ArrayList<Referee> RefereeArrayList = new ArrayList<Referee>();
    static private ArrayList<Match> MatchArrayList = new ArrayList<Match>();

    /**
     * Creates a team and stores it inside of the TeamArrayList.
     *
     * @param TeamName String
     */
    public static void createTeam(String TeamName) {
        TeamArrayList.add(new Team(TeamName));
    }

    /**
     * Creates a player and stores it inside of the PlayerArrayList.
     *
     * @param PlayerFName String
     * @param PlayerLName String
     * @param PlayerAge int
     * @param PlayerPosition String
     */
    public static void createPlayer(String PlayerFName, String PlayerLName, int PlayerAge, String PlayerPosition) {
        PlayerArrayList.add(new Player(PlayerFName, PlayerLName, PlayerAge, PlayerPosition));
    }

    /**
     * Creates a coach and stores it inside of the CoachArrayList
     *
     * @param coachFName String
     * @param coachLName String
     * @param coachAge int
     * @param formation String
     */
    public static void createCoach(String coachFName, String coachLName, int coachAge, String formation) {
        CoachArrayList.add(new Coach(coachFName, coachLName, coachAge, formation));
    }

    /**
     * Creates a referee and stores it inside of the RefereeArrayList
     *
     * @param refereeFName String
     * @param refereeLName String
     * @param refereeAge int
     * @param refereeWork String
     */
    public static void createReferee(String refereeFName, String refereeLName, int refereeAge, String refereeWork) {
        RefereeArrayList.add(new Referee(refereeFName, refereeLName, refereeAge, refereeWork));
    }

    /**
     *
     * Creates a match and stores it inside of the MatchArrayList
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
    public static void createMatch(Team homeTeam, Team awayTeam, Referee Ref, int homeScore, int awayScore, int week, ArrayList<Player> goals, ArrayList<Player> assists, ArrayList<Player> yellowCards, ArrayList<Player> redCards) {
        MatchArrayList.add(new Match(homeTeam, awayTeam, Ref, homeScore, awayScore, week, goals, assists, yellowCards, redCards));
    }

    /**
     * Deletes the player at the specified position
     *
     * @param i int
     */
    public static void deletePlayer(int i) {
        PlayerArrayList.remove(i);
    }

    /**
     * Deletes the team at the specified position
     *
     * @param i int
     */
    public static void deleteTeam(int i) {
        TeamArrayList.remove(i);
    }

    /**
     * Deletes the coach at the specified position
     *
     * @param i int
     */
    public static void deleteCoach(int i) {
        CoachArrayList.remove(i);
    }

    /**
     * Deletes the specified referee
     *
     * @param ref Referee
     */
    public static void deleteReferee(Referee ref) {
        RefereeArrayList.remove(ref);
    }

    /**
     * Gets the Player at the specified position
     *
     * @param i int
     * @return Player
     */
    public static Player getPlayer(int i) {
        return PlayerArrayList.get(i);
    }

    /**
     * Gets the referee at the specified position
     *
     * @param i int
     * @return Referee
     */
    public static Referee getReferee(int i) {
        return RefereeArrayList.get(i);
    }

    /**
     * Gets the coach at the specified position
     *
     * @param i int
     * @return Coach
     */
    public static Coach getCoach(int i) {
        return CoachArrayList.get(i);
    }

    /**
     * Gets the team at the specified position
     *
     * @param i int
     * @return Team
     */
    public static Team getTeam(int i) {
        return TeamArrayList.get(i);
    }

    /**
     * Gets the match at the specified position
     *
     * @param i int
     * @return Match
     */
    public static Match getMatch(int i) {
        return MatchArrayList.get(i);
    }

    /**
     * Returns the size of the MatchArrayList
     *
     * @return int
     */
    public static int getMatchSize() {
        return MatchArrayList.size();
    }

    /**
     * Returns the size of the RefereeArrayList
     *
     * @return int
     */
    public static int getRefereeSize() {
        return RefereeArrayList.size();
    }

    /**
     * Returns the size of the CoachArrayList
     *
     * @return int
     */
    public static int getCoachSize() {
        return CoachArrayList.size();
    }

    /**
     * Returns the size of the PlayerArrayList
     *
     * @return int
     */
    public static int getPlayerSize() {
        return PlayerArrayList.size();
    }

    /**
     * Returns the size of the TeamArrayList
     *
     * @return int
     */
    public static int getTeamSize() {
        return TeamArrayList.size();
    }

    /**
     * Checks to see if a team contains a specific player, Returns the team name
     *
     * @param player Player
     * @return String
     */
    public static String teamContains(Player player) {
        for (int i = 0; i < TeamArrayList.size(); i++) {
            if (player.getTeam().equals(TeamArrayList.get(i).getTeamName())) {
                return player.getTeam();
            }
        }
        return null;
    }

    /**
     * Sorts the MatchArrayList based on the week that the match was played from
     * earliest to latest
     */
    public static void sortMatches() {
        Collections.sort(MatchArrayList, new Comparator<Match>() {
            //Override the comaprator to sort by the match week
            @Override
            public int compare(Match m1, Match m2) {
                int comp = m1.getWeek() - m2.getWeek();
                return comp;
            }
        });
    }

    /**
     * Saves all of the data currently inside of the program
     */
    public static void saveData() {
        try {
            //Create a file for each of the classes and a ObjectOutputStream
            FileOutputStream playerOut = new FileOutputStream("Player.sir");
            ObjectOutputStream playerObjOut = new ObjectOutputStream(playerOut);
            FileOutputStream teamOut = new FileOutputStream("Team.sir");
            ObjectOutputStream teamObjOut = new ObjectOutputStream(teamOut);
            FileOutputStream matchOut = new FileOutputStream("Match.sir");
            ObjectOutputStream matchObjOut = new ObjectOutputStream(matchOut);
            FileOutputStream coachOut = new FileOutputStream("Coach.sir");
            ObjectOutputStream coachObjOut = new ObjectOutputStream(coachOut);
            FileOutputStream refereeOut = new FileOutputStream("Referee.sir");
            ObjectOutputStream refereeObjOut = new ObjectOutputStream(refereeOut);

            //Loop through the relevant arrays and add the data to the files
            for (int i = 0; i < getPlayerSize(); i++) {
                playerObjOut.writeObject(getPlayer(i));
            }
            for (int i = 0; i < getTeamSize(); i++) {
                teamObjOut.writeObject(getTeam(i));
            }
            for (int i = 0; i < getMatchSize(); i++) {
                matchObjOut.writeObject(getMatch(i));
            }
            for (int i = 0; i < getCoachSize(); i++) {
                coachObjOut.writeObject(getCoach(i));
            }
            for (int i = 0; i < getRefereeSize(); i++) {
                refereeObjOut.writeObject(getReferee(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all of the data into the program and updates the relevant lists,
     * doesn't import the match data
     */
    public static void loadData() {
        try {
            //Creating the FileInputStreams and the ObjectInputStreams for loading the data
            FileInputStream playerIn = new FileInputStream("Player.sir");
            ObjectInputStream playerObjIn = new ObjectInputStream(playerIn);
            FileInputStream teamIn = new FileInputStream("Team.sir");
            ObjectInputStream teamObjIn = new ObjectInputStream(teamIn);
            FileInputStream coachIn = new FileInputStream("Coach.sir");
            ObjectInputStream coachObjIn = new ObjectInputStream(coachIn);
            FileInputStream refereeIn = new FileInputStream("Referee.sir");
            ObjectInputStream refereeObjIn = new ObjectInputStream(refereeIn);
            boolean playerLoaded = false;
            boolean teamLoaded = false;
            boolean coachLoaded = false;
            boolean refereeLoaded = false;

            //Looping through each file until there is no more data and adding it to the relevant list
            while (!playerLoaded) {
                if (playerIn.available() == 0) {
                    playerLoaded = true;
                    break;
                }
                PlayerArrayList.add((Player) playerObjIn.readObject());
            }
            while (!teamLoaded) {
                if (teamIn.available() == 0) {
                    teamLoaded = true;
                    break;
                }
                TeamArrayList.add((Team) teamObjIn.readObject());
            }

            while (!coachLoaded) {
                if (coachIn.available() == 0) {
                    coachLoaded = true;
                    break;
                }
                CoachArrayList.add((Coach) coachObjIn.readObject());
            }
            while (!refereeLoaded) {
                if (refereeIn.available() == 0) {
                    refereeLoaded = true;
                    break;
                }
                RefereeArrayList.add((Referee) refereeObjIn.readObject());
            }
        } catch (FileNotFoundException F) {
            F.printStackTrace();
        } catch (EOFException E) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException C) {
            C.printStackTrace();
        }

        //Updating the relevant list elements with the imported data
        for (int i = 0; i < TeamArrayList.size(); i++) {
            jflmanagement.GUI.JFLGUI.TeamListManager.addElement(TeamArrayList.get(i).getTeamName());
        }
        for (int i = 0; i < PlayerArrayList.size(); i++) {
            if (PlayerArrayList.get(i).getOnTeam() == true) {
                jflmanagement.GUI.JFLGUI.PlayerListManager.addElement("Player is on " + teamContains(getPlayer(i)) + " : " + PlayerArrayList.get(i).getFName() + " " + PlayerArrayList.get(i).getLName());
            } else {
                jflmanagement.GUI.JFLGUI.PlayerListManager.addElement(PlayerArrayList.get(i).getFName() + " " + PlayerArrayList.get(i).getLName());
            }
        }

        for (int i = 0; i < CoachArrayList.size(); i++) {
            if (CoachArrayList.get(i).getOnTeam() == true) {
                for (int j = 0; j < TeamArrayList.size(); j++) {
                    if (TeamArrayList.get(j).getCoach() != null) {
                        if (TeamArrayList.get(j).getCoach().getFName().equals(CoachArrayList.get(i).getFName()) && TeamArrayList.get(j).getCoach().getLName().equals(CoachArrayList.get(i).getLName())) {
                            jflmanagement.GUI.JFLGUI.CoachListManager.addElement("Coach is on " + TeamArrayList.get(j).getTeamName() + ": " + CoachArrayList.get(i).getFName() + " " + CoachArrayList.get(i).getLName());
                        }
                    }
                }
            } else {
                jflmanagement.GUI.JFLGUI.CoachListManager.addElement(CoachArrayList.get(i).getFName() + " " + CoachArrayList.get(i).getLName());
            }
        }
        for (int i = 0; i < RefereeArrayList.size(); i++) {
            jflmanagement.GUI.JFLGUI.RefereeListManager.addElement(RefereeArrayList.get(i).getFName() + " " + RefereeArrayList.get(i).getLName());
        }
    }

    /**
     * Loads the Match data into the program and updates the relevant lists.
     *
     * @param file File
     * @throws FileNotFoundException Exception
     * @throws IOException Exception
     * @throws ClassNotFoundException Exception
     */
    public static void updateMatches(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean matchLoaded = false;
        //Creates a FileInputStream and ObjectInputStream for the selected file
        FileInputStream matchIn = new FileInputStream(file);
        ObjectInputStream matchObjIn = new ObjectInputStream(matchIn);

        //Loops through the files data and adds it to the MatchArrayList
        while (!matchLoaded) {
            if (matchIn.available() == 0) {
                matchLoaded = true;
                break;
            }
            MatchArrayList.add((Match) matchObjIn.readObject());
        }

        //Updates the Match list with the imported matches.
        for (int i = 0; i < MatchArrayList.size(); i++) {
            jflmanagement.GUI.JFLGUI.MatchesListManager.addElement(MatchArrayList.get(i).getHomeTeam().getTeamName() + " V " + MatchArrayList.get(i).getAwayTeam().getTeamName());
        }
        //Updates the player table
        updatePlayerTable();
    }

    /**
     * Updates the League table, sorts the team by points, most points at the
     * top
     */
    public static void updateLeagueTable() {
        //Creates a points array
        ArrayList<Integer> points = new ArrayList();
        Boolean sorted = false;
        //Adds the points from all of the teams to the arraylist
        for (int i = 0; i < getTeamSize(); i++) {
            points.add(getTeam(i).getPoints());
        }
        //Sorts the arraylist
        points.sort(null);
        //Reverses the array lsit
        Collections.reverse(points);
        //Removes all of the rows from the current league table
        while (jflmanagement.GUI.JFLGUI.LeagueTableManager.getRowCount() > 0) {
            jflmanagement.GUI.JFLGUI.LeagueTableManager.removeRow(0);
        }
        try {
            //While loop to add the teams back to the LeagueTable with the highest scoreing one at the top
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < getTeamSize(); i++) {
                    Team team = getTeam(i);
                    if (points.isEmpty()) {
                        break;
                    }
                    if (points.get(0) == team.getPoints()) {

                        Object[] data = new Object[7];

                        data[0] = jflmanagement.GUI.JFLGUI.LeagueTableManager.getRowCount() + 1;
                        data[1] = team.getTeamName();
                        data[2] = team.getWins();
                        data[3] = team.getDraws();
                        data[4] = team.getLosses();
                        data[5] = team.getTotalGoals();
                        data[6] = team.getPoints();

                        jflmanagement.GUI.JFLGUI.LeagueTableManager.addRow(data);
                        points.remove(0);
                        sorted = false;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Updates the player table
     */
    public static void updatePlayerTable() {
        //Remove all of the current rows from the table
        while (jflmanagement.GUI.JFLGUI.PlayerTableManager.getRowCount() > 0) {
            jflmanagement.GUI.JFLGUI.PlayerTableManager.removeRow(0);
        }
        //Loops through the PlayerArrayList and then adds them to the the table
        for (int i = 0; i < getPlayerSize(); i++) {
            Player player = getPlayer(i);

            Object[] data = new Object[7];

            data[0] = player.getFName() + " " + player.getLName();
            data[1] = player.getTotalGoals();
            data[2] = player.getTotalAssists();
            data[3] = player.getYellowCards();
            data[4] = player.getRedCards();

            jflmanagement.GUI.JFLGUI.PlayerTableManager.addRow(data);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadData();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLGUI().setVisible(true);
            }
        });

    }

}
