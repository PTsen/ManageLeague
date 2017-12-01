package manageleague;

import sun.util.calendar.BaseCalendar;

import java.util.Date;
import java.util.List;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class League implements Serializable {

    //Private fields
    private String name;
    private int nbr_teams;
    private Date start_date;   //League season
    private Date end_date; 
    private List<Team> list_of_teams;
    private List<Match> list_of_matches;

    //Constructor method
    public League(String name, Date start, Date end) {
        this.name = name;
        this.start_date = start;
        this.end_date = end;
    }

    //Accessors
    public String getName() {
        return name;
    }

    public int getNbr_teams() {
        return nbr_teams;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public List<Team> getList_of_teams() {

        return list_of_teams;
    }

    public List<Match> getList_of_matches() {
        return list_of_matches;
    }

    //Methods

    public void addTeams(String name){
    	Team team = new Team(name);
        list_of_teams.add(team);
    }

    public void addMatch(Match match){

        list_of_matches.add(match);
    }
    
    public void updateDB() {
    	FileOutputStream fout = null;
    	ObjectOutputStream oos = null;
    	
		try {
			fout = new FileOutputStream("C:\\");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			oos = new ObjectOutputStream(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	try {
			oos.writeObject(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
