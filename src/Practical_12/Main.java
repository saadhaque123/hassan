package Practical_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // create an instance of the FootballLeague class
        FootballLeague league = new FootballLeague();

        // create several Team objects
        Team team1 = new Team("Team 1", 3, 1, 0);
        Team team2 = new Team("Team 2", 2, 1, 1);
        Team team3 = new Team("Team 3", 1, 2, 1);
        Team team4 = new Team("Team 4", 0, 3, 1);

        // add the teams to the league
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);

        // create an instance of the Dashboard class and print the league table
        Dashboard dashboard = new Dashboard(league);
        dashboard.printLeagueTable();

        // update the wins and draws of team1 and team2
        team1.setWins(4);
        team2.setDraws(2);
        league.updateTeam(team1);
        league.updateTeam(team2);
        dashboard.printLeagueTable();

        // remove team3 from the league
        league.removeTeam(team3);
        dashboard.printLeagueTable();

        // relegate the teams with the least amount of points
        league.relegateTeams();
        dashboard.printLeagueTable();
    }
}

class Team implements Comparable<Team> {
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private int points;

    // constructor for the Team class
    public Team(String name, int wins, int draws, int losses) {
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.points = (3 * wins) + draws;
    }

    // getters and setters for the class properties
    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        this.points = (3 * wins) + draws;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        this.points = (3 * wins) + draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return points;
    }
    // implementation of the compareTo method to allow teams to be ordered based on their points
    @Override
    public int compareTo(Team o) {
        if (this.points != o.points) {
            return o.points - this.points;
        } else {
            return this.name.compareTo(o.name);
        }
    }
    //overriding the tostring method to return a human-friendly representation of the team
    @Override
    public String toString() {
        return String.format("%s, Pts: %d, W: %d, D: %d, L: %d", name, points, wins, draws, losses);
    }
}

class FootballLeague {
    private List<Team> teams;
    // constructor for the FootballLeague class
    public FootballLeague() {
        teams = new ArrayList<>();
    }
    // method to add a team to the league
    public void addTeam(Team team) {
        teams.add(team);
        Collections.sort(teams);
    }

    // method to update a team in the league
    public void updateTeam(Team team) {
        teams.remove(team);
        teams.add(team);
        Collections.sort(teams);
    }

    // method to remove a team from the league
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    // method to relegate teams at the end of the season
    public void relegateTeams() {
        int numTeamsToRelegate = 3;
        if (teams.size() > numTeamsToRelegate) {
            teams.subList(teams.size() - numTeamsToRelegate, teams.size()).clear();
        }
    }

    // method to get the teams in the league
    public List<Team> getTeams() {
        return teams;
    }
}

class Dashboard {
    private FootballLeague league;

    public Dashboard(FootballLeague league) {
        this.league = league;
    }
    // method to print the league table
    public void printLeagueTable() {
        System.out.println("League Table:");
        for (Team team : league.getTeams()) {
            System.out.println(team);
        }
    }
}
