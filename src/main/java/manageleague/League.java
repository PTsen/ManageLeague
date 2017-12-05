package manageleague;

import sun.util.calendar.BaseCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    //creation of the singleton
    private static League instance = new League();

    //Constructor method (Private)
    private League() {
        list_of_teams = new ArrayList<Team>();
        list_of_matches = new ArrayList<Match>();

    }
    
    //Singleton access
    public static League getInstance() {
    	return instance;
    }
    
    //Setters
    public void init(String name, String start, String end) {
    	this.setName(name);
    	this.setStart(start);
    	this.setEnd(end);
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setStart(String start) {
    	tryParse(start, "start");
    }
    
    public void setEnd(String end) {
    	tryParse(end, "end");
    }

    //Accessors
    public String getName() {
        return name;
    }

    public int getNbr_teams() {
        return nbr_teams;
    }

    public Date getStart_date() {
        if(start_date == null){
            throw new NullPointerException();
        }
        return start_date;
    }

    public Date getEnd_date() {
        if(end_date == null){
            throw new NullPointerException();
        }
        return end_date;
    }

    public List<Team> getList_of_teams() { return list_of_teams; }

    public List<Match> getList_of_matches() {
        return list_of_matches;
    }

    //Methods

    public void addTeams(String name){
    	Team team = new Team(name);
        list_of_teams.add(team);
    }

    public void addMatch(String home_team, String away_team, String date){
    	Team h_team = getTeam(home_team);
    	Team a_team = getTeam(away_team);
    	
    	Date match_date = convertToDate(date);
    	Match match = new Match(h_team, a_team, match_date);
    	list_of_matches.add(match);
    }
    
    public Team getTeam(String team) {
    	for (Team team_item : list_of_teams) {
    		if (team_item.getName() == team) {
    			return team_item;
    		}
    	}
    	
    	throw new java.lang.Error("No existing team");
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

    private void tryParse(String dateString, String datetime)
    {
    	if(datetime == "start") {
    		start_date = convertToDate(dateString);
    	}
    	if(datetime == "end") {
    		end_date =   convertToDate(dateString);
    	}
    }
    
    private Date convertToDate(String date) {
    	Date converted_date = new Date();
    	List<String> formatStrings = Arrays.asList("dd/MM/yyyy","dd/MM/yy", "d/M/yyyy", "d/M/yy");
        for (String formatString : formatStrings) {
        	try {
        		converted_date = new SimpleDateFormat(formatString).parse(date);
        	} catch (ParseException e) {
        		e.getMessage();
        	}
        }
        
        return converted_date;
    }
    
    public void reset() {
    	name = "";
        nbr_teams= 0;
        start_date = new Date();   //League season
        end_date = new Date();
        list_of_teams.clear();
        list_of_matches.clear();
    }
}
