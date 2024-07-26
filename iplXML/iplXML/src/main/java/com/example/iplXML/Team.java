package com.example.iplXML;

public class Team {
	private int id;
    private String teamName;
    private String captainName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", captainName=" + captainName + "]";
	}
    
    
    
    
    
    
}
