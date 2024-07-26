package com.example.iplXML;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class TeamService {
	private Team team;
    private Map<Integer, Team> teamDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Map<Integer, Team> getTeamDatabase() {
        return teamDatabase;
    }

    public void setTeamDatabase(Map<Integer, Team> teamDatabase) {
        this.teamDatabase = teamDatabase;
    }

    public void addTeam(Team team) {
        teamDatabase.put(team.getId(), team);
    }

    public void updateTeam(Team updatedTeam) {
        teamDatabase.put(updatedTeam.getId(), updatedTeam);
    }

    public void deleteTeam(int teamId) {
    	teamDatabase.remove(teamId);
    }

    public Team getTeam(int teamId) {
        return teamDatabase.get(teamId);
    }

    

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Team");
            System.out.println("2. Update Team Info");
            System.out.println("3. Delete Team");
            System.out.println("4. Get Team by ID");
            System.out.println("5. Display All Teams");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTeamFromInput();
                    break;
                case 2:
                    updateTeamFromInput();
                    break;
                case 3:
                    deleteTeamFromInput();
                    break;
                case 4:
                    getTeamById();
                    break;
                case 5:
                    displayAllTeams();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addTeamFromInput() {
        System.out.print("Enter team ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter team name: ");
        String name = scanner.next();
        System.out.print("Enter captain name: ");
        String captainName = scanner.next();
        
        Team newTeam = new Team();
        newTeam.setId(id);
        newTeam.setTeamName(name);
        newTeam.setCaptainName(captainName);
        addTeam(newTeam);
        System.out.println("Team added successfully.");
    }

    private void updateTeamFromInput() {
        System.out.print("Enter team ID to update: ");
        int id = scanner.nextInt();
        Team existingTeam = getTeam(id);
        if (existingTeam != null) {
            System.out.print("Enter updated captain name: ");
            String name = scanner.next();
            existingTeam.setCaptainName(name);
            updateTeam(existingTeam);
            System.out.println("Team captain updated successfully.");
        } else {
            System.out.println("Team not found with ID " + id);
        }
    }

    private void deleteTeamFromInput() {
        System.out.print("Enter team ID to delete: ");
        int id = scanner.nextInt();
        Team existingTeam = getTeam(id);
        if (existingTeam != null) {
            deleteTeam(id);
            System.out.println("Team deleted successfully.");
        } else {
            System.out.println("Team not found with ID " + id);
        }
    }

    private void getTeamById() {
        System.out.print("Enter team ID to retrieve: ");
        int id = scanner.nextInt();
        Team existingTeam = getTeam(id);
        if (existingTeam != null) {
            System.out.println("Team details:");
            System.out.println(existingTeam);
        } else {
            System.out.println("Team not found with ID " + id);
        }
    }
    
    public void displayAllTeams() {
        System.out.println("Teams List:");
        for (Team i : teamDatabase.values()) {
            System.out.println(i);
        }
    }
}
