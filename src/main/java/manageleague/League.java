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

    //Constructor method
    public League(String name, String start, String end) {
        this.name = name;
        tryParse(start, "start");
        tryParse(end, "end");
        list_of_teams = new ArrayList<Team>();
        list_of_matches = new ArrayList<Match>();

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

        //list_of_matches.add(match);
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
        List<String> formatStrings = Arrays.asList("dd/MM/yyyy","dd/MM/yy", "d/M/yyyy", "d/M/yy");
        for (String formatString : formatStrings)
        {
            if(datetime == "start") {
                try {
                    //return new SimpleDateFormat(formatString).parse(dateString);
                    start_date = new SimpleDateFormat(formatString).parse(dateString);
                } catch (ParseException e) {
                    e.getMessage();
                }
            }
            if(datetime == "end") {
                try {
                    end_date = new SimpleDateFormat(formatString).parse(dateString);
                } catch (ParseException e) {
                    e.getMessage();
                }
            }
        }
    }
}
