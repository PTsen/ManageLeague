package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import manageleague.League;
import org.junit.Test;
import sun.util.calendar.BaseCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testLeague {

    public testLeague() {
    }

    /**
     * Test Constructor method for {@link League#League()}.
     */
    @Test
    public void testLeagueConstruct() {

        //Case 1
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String league_name = "English Premier League";
        String start = "26/08/2017";
        String end = "26/05/2018";

        manageleague.League english_league = manageleague.League.getInstance();
        english_league.setName(league_name);
        english_league.setStart(start);
        english_league.setEnd(end);

        assertThat("No name for League", english_league.getName(), is(league_name));
        assertThat("No start date for league",df.format(english_league.getStart_date()), is(start));
        assertThat("No end date for league",df.format(english_league.getEnd_date()), is(end));

        //Case 2
        DateFormat df1 = new SimpleDateFormat("dd/MM/yy");
        String start1 = "26/08/17";
        String end1 = "26/05/18";

        english_league.setStart(start1);
        english_league.setEnd(end1);

        assertTrue("No name for League", english_league.getName() == league_name);
        assertThat("No start date for league",df.format(english_league.getStart_date()), is(start));
        assertThat("No end date for league",df.format(english_league.getEnd_date()), is(end));

        //Case 3
        DateFormat df2 = new SimpleDateFormat("d/M/yyyy");
        String start2 = "26/8/2017";
        String end2 = "26/5/2018";

        english_league.setStart(start2);
        english_league.setEnd(end2);

        assertTrue("No name for League", english_league.getName() == league_name);
        assertThat("No start date for league",df.format(english_league.getStart_date()), is(start));
        assertThat("No end date for league",df.format(english_league.getEnd_date()), is(end));

        //Case 4
        DateFormat df3 = new SimpleDateFormat("d/M/yy");
        String start3 = "26/8/17";
        String end3 = "26/5/18";

        english_league.setStart(start3);
        english_league.setEnd(end3);

        assertTrue("No name for League", english_league.getName() == league_name);
        assertThat("No start date for league",df.format(english_league.getStart_date()), is(start));
        assertThat("No end date for league",df.format(english_league.getEnd_date()), is(end));

        english_league.reset();  //reset singleton object[League] to base values

    }

    /**
     * Test method for {@link manageleague.League#tryParse(String, String) and convertToDate(String, String)}.
     * Test for when setting date with wrong format. Class throws null argument
     * exception.
     */
    @Test (expected = NullPointerException.class)
    public final void testWrongDateFormat() {

        //Case 1
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String league_name = "Spanish Premier League";
        String start1 = "08-26-2017";
        String end1 = "05-26-2018";

        manageleague.League la_liga = manageleague.League.getInstance();
        la_liga.setName(league_name);
        la_liga.setStart(start1);
        la_liga.setEnd(end1);


        assertTrue("League name set", la_liga.getName() == league_name);
        assertThat("start date for league",df.format(la_liga.getStart_date()), is(nullValue()));
        assertThat("end date for league",df.format(la_liga.getEnd_date()), is(nullValue()));

        //Case 2
        String start2 = "2017/08/26";
        String end2 = "2018/05/26";

        la_liga.setStart(start2);
        la_liga.setEnd(end2);


        assertTrue("name for League", la_liga.getName() == league_name);
        assertThat("start date for league",df.format(la_liga.getStart_date()), is(nullValue()));
        assertThat("end date for league",df.format(la_liga.getEnd_date()), is(nullValue()));

        //Case 3
        String start3 = "08/26/2017";
        String end3 = "05/26/2018";

        la_liga.setStart(start3);
        la_liga.setEnd(end3);

        assertTrue("name for League", la_liga.getName() == league_name);
        assertThat("start date for league",df.format(la_liga.getStart_date()), is(nullValue()));
        assertThat("end date for league",df.format(la_liga.getEnd_date()), is(nullValue()));

    }

    /**
     * Test method for {@link manageleague.League#getTeam(String)}.
     * Test that exception is thrown when a is not found/doesn't exist.
     */
    @Test (expected = java.lang.Error.class)
    public final void testGetTeam() {

        String league_name = "English Premier League";
        String team_name1 = "Arsenal";
        String team_name2 = "Manchester United";
        String not_team = "Baghdad";
        String start = "26/8/2017";
        String end = "26/5/2018";

        manageleague.League english_league = manageleague.League.getInstance();
        english_league.reset();
        english_league.setName(league_name);
        english_league.setStart(start);
        english_league.setEnd(end);
        english_league.addTeams(team_name1);
        english_league.addTeams(team_name2);

        assertThat("Non-exisiting team",english_league.getTeam(not_team).getName(), is(not_team));

    }

    /**
     * Test method for {@link League#reset()}.
     */
    @Test
    public void testReset() {

        int result = 0;
        String str_result1 = "";
        String str_result2 = "6/12/2017"; //dates are rest to today's date
        DateFormat df = new SimpleDateFormat("d/M/yyyy");

        manageleague.League english_league = manageleague.League.getInstance();
        english_league.reset();

        assertTrue("list of matches not reset", english_league.getList_of_matches().size() == result);
        assertTrue("list of teams not reset", english_league.getList_of_teams().size() == result);
        assertThat("Date was not reset",df.format(english_league.getEnd_date()), is(str_result2));
        assertThat("Date was not reset",df.format(english_league.getEnd_date()), is(str_result2));
        assertThat("Number of teams not reset",english_league.getNbr_teams(), is(result));
        assertThat("name not reset",english_league.getName(), is(str_result1));
    }

    /**
     * Test method for {@link manageleague.League#addTeams(String)}.
     */
    @Test
    public void testAddTeams() {
        int RESULT = 2;
        String league_name = "English Premier League";
        String team_name1 = "Arsenal";
        String team_name2 = "Manchester United";
        String start = "26/8/2017";
        String end = "26/5/2018";

        manageleague.League english_league = manageleague.League.getInstance();
        english_league.reset();
        english_league.setName(league_name);
        english_league.setStart(start);
        english_league.setEnd(end);
        //Call test method and test if a team has been added to list
        english_league.addTeams(team_name1);
        english_league.addTeams(team_name2);

        assertThat("No team was added", english_league.getList_of_teams().size(), is(RESULT));
        assertThat("team1 was not added to list",english_league.getList_of_teams().get(0).getName(), is(team_name1));
        assertThat("team2 was not added to list",english_league.getList_of_teams().get(1).getName(), is(team_name2));

    }

    /**
     * Test method for {@link manageleague.League#addMatch(String, String, String)}.
     */
    @Test
    public void testAddMatch() {

        int result = 1;
        String league_name = "English Premier League";
        DateFormat df = new SimpleDateFormat("d/M/yyyy");
        String start = "26/08/2017";
        String end = "26/05/2018";
        String home_team = "Arsenal";
        String away_team = "Manchester United";
        String date = "2/12/2017";


        manageleague.League english_league = manageleague.League.getInstance();
        english_league.reset();
        english_league.setName(league_name);
        english_league.setStart(start);
        english_league.setEnd(end);
        english_league.addTeams(home_team);  //Call test method
        english_league.addTeams(away_team);
        english_league.addMatch(home_team, away_team, date);

        assertTrue("No match was added", english_league.getList_of_matches().size() == result);
        assertThat("Date was not set",df.format(english_league.getList_of_matches().get(0).getMatch_date()), is(date));
        assertThat("Home team not defined",english_league.getList_of_matches().get(0).getHome_team().getName(), is(home_team));
        assertThat("Away team not defined",english_league.getList_of_matches().get(0).getAway_team().getName(), is(away_team));
    }

    //@testUpdateDB
}
