import manageleague.Match;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manageleague.Team;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import manageleague.League;


public class DatabaseHelper{
	
	private League league;


	public DatabaseHelper() {
		League league = League.getInstance();
		}
	
	
	/*Display m'envoie une liste avec le nom du championnat ainsi que les deux dates
	 * Cette fonction les set dans l'objet League*/
	public void init(String name, String start, String end) {
		league.init(name,start,end);
	}
	
	
	/*@pre: reçoit une liste de 8 teams en paramètres
	 *@post : intègre la liste de match à l'objet League
	 *DONE */
	public void addTeams( List<String> teams) {
		for(int i=0; i<teams.size(); i++){
			league.addTeams(teams.get(i));
		}
	}
	
	/*This function receives a list of strings (the names of the teams), generate the different matches, incorporate them in the league and
	 * returns a list of the match for the display*/
	
	public List<String> generateMatches(List<String> teams){
	
		Random random = new Random();
		String matches[][]= new String[teams.size()/2][];
		
		int i =0;
		
		while (teams.size()>0) {
		    int q = random.nextInt(teams.size());
		    String team1 = teams.get(q);
		    teams.remove(q);
		    q = random.nextInt(teams.size());
		    String team2 = teams.get(q);
		    teams.remove(q);
		    
		    league.addMatch(team1, team2, league.getStart_date().toString());
		    
		    matches[i][1]= team1;
		    matches[i][2]=team2;
		}
	
}
	
	
	/*Display m'envoie deux équipes et je retourne le match correspondant 
	 * DONE */
	public Match getMatch (String team1, String team2){
		match = DatabaseManagment.getMatch(team1, team2);
		}
	
	/*
	 * Display m'envoie un string du nom d'equipe, je demande a DB de m'envoyer la team correspondante
	 * DONE */
	public Team getTeam (String team_name){
			team = DatabaseManagment.getTeam(team_name);
			return team;
		}
	
	public League getLeague() {
		
	}
	
	
	
	
	
	
	
	public void cancelMatch () {
		
	}
	
	public void cancelTeam() {
		
	}
	
	public void cancelLeague() {}
	


}

