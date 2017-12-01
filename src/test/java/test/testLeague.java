package test;

import static org.junit.Assert.*;
//import org.junit.Ignore;

import manageleague.Match;
import manageleague.Team;
import org.junit.Test;

import java.util.Date;

public class testLeague {

    public testLeague() {

    }

    /**
     * Test method for {@link manageleague.League#AddTeams(Team)}}.
     */
    @Test
    public void testAddTeams() {

        int result = 2;
        String team_name = "Manchester United";
        //Test if a team has been added to list
        Date date_start = new Date(2017,8,26);
        Date date_end = new Date(2018,5,26);
        manageleague.League englishLeague = new manageleague.League("English Premier League", date_start, date_end);
        Team arsenal = new Team("Arsenal");
        Team manu = new Team("Manchester United");
        englishLeague.AddTeams(arsenal);  //Call test method
        englishLeague.AddTeams(manu);

        assertTrue("No team was added", englishLeague.getList_of_teams().size() == result);
        assertTrue("No name for team", englishLeague.getList_of_teams().get(1).equals(team_name));
    }

    /**
     * Test method for {@link manageleague.League#AddTeams(Team)}}.
     */
    @Test
    public void testAddMatch() {

        int result = 1;
        String team_name = "Arsenal";

        Date match_date = new Date(2017,8,26);
        Date date_start = new Date(2017,8,26);
        Date date_end = new Date(2018,5,26);
        manageleague.League englishLeague = new manageleague.League("English Premier League", date_start, date_end);
        Team arsenal = new Team("Arsenal");
        Team manu = new Team("Manchester United");
        englishLeague.AddTeams(arsenal);  //Call test method
        Match match1 = new Match(manu, arsenal, match_date);

        assertTrue("No match was added", englishLeague.getList_of_teams().size() == result);
        assertTrue("Can't get date", englishLeague.getList_of_matches().get(0).getMatch_date().equals((match_date)));
    }
}
