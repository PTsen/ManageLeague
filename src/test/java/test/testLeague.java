package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import manageleague.Match;
import manageleague.Team;
import org.junit.Test;

import java.util.Date;

public class testLeague {

    public testLeague() {

    }

    /**
     * Test Constructor method for {@link manageleague.League#League(String, Date, Date)}.
     */
    @Test
    public void testLeagueConstruct() {

        String team_name = "English Premier League";
        Date date_start = new Date(2017,8,26);
        Date date_end = new Date(2018,5,26);
        manageleague.League englishLeague = new manageleague.League("English Premier League", date_start, date_end);

        assertTrue("No name for League", englishLeague.getName() == team_name);
        assertTrue("No start date for league", englishLeague.getEnd_date() == date_end);
        assertTrue("No end date for league", englishLeague.getStart_date() == date_start);
    }

    /**
     * Test method for {@link manageleague.League#addTeams(String)}.
     */
    @Test
    public void testAddTeams() {

        int result = 2;
        String team_name = "Arsenal";
        Date date_start = new Date(2017,8,26);
        Date date_end = new Date(2018,5,26);
        manageleague.League englishLeague = new manageleague.League("English Premier League", date_start, date_end);
        Team arsenal = new Team(team_name);
        //Call test method. Test if a team has been added to list
        englishLeague.addTeams(team_name);
        englishLeague.addTeams("Manchester United");

        //assertThat(englishLeague.getList_of_teams(), hasItems(arsenal));
        //assertTrue("No team was added", englishLeague.getList_of_teams().size() == result);
    }

    /**
     * Test method for {@link manageleague.League#addMatch(Match)}.
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
        englishLeague.addTeams("Arsenal");  //Call test method
        englishLeague.addTeams("Manchester United");  //Call test method
        Match match1 = new Match(manu, arsenal, match_date);

        assertTrue("No match was added", englishLeague.getList_of_teams().size() == result);
        assertTrue("Can't get date", englishLeague.getList_of_matches().get(0).getMatch_date().equals((match_date)));
    }
}
