package database;
import manageleague.Match;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manageleague.Team;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import manageleague.League;


public class DatabaseHelper{
	
	private League league;


	public DatabaseHelper() {
		League league = League.getInstance();
		}
	
	public League getLeague() {
		return league.getInstance();
	}
	
	/*Display m'envoie une liste avec le nom du championnat ainsi que les deux dates
	 * Cette fonction les set dans l'objet League
	 * DONE*/
	public void init(List<String> inits) {
		League l = league.getInstance();
		l.init(inits.get(0), inits.get(1), inits.get(2));
	}
	
	
	/*@pre: reçoit une liste de 8 teams en paramètres (strings)
	 *@post : intègre la liste de match à l'objet League
	 *DONE */
	public void addTeams( List<String> teams) {
		League l = league.getInstance();
		for(int i=0; i<teams.size(); i++){
			l.addTeams(teams.get(i));
		}
	}

	
	/*This function receives an ArrayList<String> containing the names of the teams
	 * Returns a list of Matches*/
	
	
	public List<Match> generateMatches(ArrayList<String> teams){
	
		League l = league.getInstance();
		Random random = new Random();
		
		int i =0;
		//System.out.println(teams);
		
		while (teams.size()>0) {
		    int q = random.nextInt(teams.size());
		    String team1 = teams.get(q);
		    teams.remove(teams.get(q));
		    q = random.nextInt(teams.size());
		    String team2 = teams.get(q);
		    teams.remove(q);
		    
		    l.addMatch(team1, team2, "23/08/2012");
		    //System.out.println(team1+"   "+team2);
		}
		
		
		return l.getList_of_matches();
		
	
}
	
	
	/*Display m'envoie deux équipes et je retourne le match correspondant 
	 * DONE */
	public Match getMatch (String team1, String team2){
		//Match match = DatabaseManagment.getMatch(team1, team2);
		}
	
	/* Display m'envoie un string du nom d'equipe, je demande a DB de m'envoyer la team correspondante
	 **/
	public Team getTeam (String team_name){
			//team = DatabaseManagment.getTeam(team_name);
			//return team;
		}
	
	/* Display me demande la league, je demande a DB de m'envoyer la league
	 **/
	public Team getLeague(){
		//team = DatabaseManagment.getLeague();
		//return team;
	}
	
	
	// corespond à un match nul
	public void cancelMatch (Match match) {
		match.setScores(0, 0);
	}
	
	//On peut retirer des équipes pour avoir 1, 4, 8 équipes restantes. Après avoir retiré des equipes on regénère les matchs. Problème : les listes ne sont pas struct modifiables
	public void cancelTeam() {
		
	}
	
	public void cancelLeague() {
		League l = league.getInstance();
		l.reset();
	}
	


}

