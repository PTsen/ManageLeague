package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class testLeague {

    public testLeague() {
    }

    /**
     * Test Constructor method for {@link manageleague.League#League(String, String, String)}.
     */
    @Test
    public void testLeagueConstruct() {

        //Case 1
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String league_name = "English Premier League";
        String start = "26/08/2017";
        String end = "26/05/2018";

        manageleague.League englishLeague = new manageleague.League(league_name, start, end);

        assertTrue("No name for League", englishLeague.getName() == league_name);
        assertThat("No start date for league",df.format(englishLeague.getStart_date()), is(start));
        assertThat("No end date for league",df.format(englishLeague.getEnd_date()), is(end));

        //Case 2
        DateFormat df1 = new SimpleDateFormat("dd/MM/yy");
        String start1 = "26/08/17";
        String end1 = "26/05/18";

        manageleague.League englishLeague1 = new manageleague.League(league_name, start1, end1);

        assertTrue("No name for League", englishLeague1.getName() == league_name);
        assertThat("No start date for league",df.format(englishLeague1.getStart_date()), is(start));
        assertThat("No end date for league",df.format(englishLeague1.getEnd_date()), is(end));

        //Case 3
        DateFormat df2 = new SimpleDateFormat("d/M/yyyy");
        String start2 = "26/8/2017";
        String end2 = "26/5/2018";

        manageleague.League englishLeague2 = new manageleague.League(league_name, start2, end2);

        assertTrue("No name for League", englishLeague2.getName() == league_name);
        assertThat("No start date for league",df.format(englishLeague2.getStart_date()), is(start));
        assertThat("No end date for league",df.format(englishLeague2.getEnd_date()), is(end));

        //Case 4
        DateFormat df3 = new SimpleDateFormat("d/M/yy");
        String start3 = "26/8/17";
        String end3 = "26/5/18";

        manageleague.League englishLeague3 = new manageleague.League(league_name, start3, end3);

        assertTrue("No name for League", englishLeague3.getName() == league_name);
        assertThat("No start date for league",df.format(englishLeague3.getStart_date()), is(start));
        assertThat("No end date for league",df.format(englishLeague3.getEnd_date()), is(end));

    }

    /**
     * Test method for {@link manageleague.League#tryParse(String, String)}.
     * Test for when setting date with wrong format. Class throws parse
     * exception.
     */
    @Test (expected = NullPointerException.class)
    public final void testWrongDateFormat() {

        //Case 1
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String league_name1 = "Spanish Premier League";
        String start1 = "08-26-2017";
        String end1 = "05-26-2018";

        manageleague.League spanishLeague = new manageleague.League(league_name1, start1, end1);

        assertTrue("League name not set", spanishLeague.getName() == league_name1);
        assertThat("No start date for league",df.format(spanishLeague.getStart_date()), is(nullValue()));
        assertThat("No end date for league",df.format(spanishLeague.getEnd_date()), is(nullValue()));

        //Case 2
        String league_name2 = "German Premier League";
        String start2 = "2017/08/26";
        String end2 = "2018/05/26";

        manageleague.League germanLeague = new manageleague.League(league_name2, start2, end2);

        assertTrue("No name for League", germanLeague.getName() == league_name2);
        assertThat("No start date for league",df.format(germanLeague.getStart_date()), is(nullValue()));
        assertThat("No end date for league",df.format(germanLeague.getEnd_date()), is(nullValue()));

        //Case 3
        String league_name3 = "French Premier League";
        String start3 = "08/26/2017";
        String end3 = "05/26/2018";

        manageleague.League frenchLeague = new manageleague.League(league_name3, start3, end3);

        assertTrue("No name for League", germanLeague.getName() == league_name3);
        assertThat("No start date for league",df.format(germanLeague.getStart_date()), is(nullValue()));
        assertThat("No end date for league",df.format(germanLeague.getEnd_date()), is(nullValue()));

    }

    /**
     * Test method for {@link manageleague.League#addTeams(String)}.
     */
    @Test
    public void testAddTeams() {

        int result = 2;
        String team_name1 = "Arsenal";
        String team_name2 = "Manchester United";
        String start = "26/8/2017";
        String end = "26/5/2018";

        manageleague.League englishLeague = new manageleague.League("English Premier League", start, end);
        //Call test method and test if a team has been added to list
        englishLeague.addTeams(team_name1);
        englishLeague.addTeams(team_name2);

        assertTrue("No team was added", englishLeague.getList_of_teams().size() == result);
        assertThat("team1 was not added to list",englishLeague.getList_of_teams().get(0).getName(), is(team_name1));
        assertThat("team2 was not added to list",englishLeague.getList_of_teams().get(1).getName(), is(team_name2));

    }

    /**
     * Test method for {@link manageleague.League#addMatch(String, String, String)}.
     */
    @Test
    public void testAddMatch() {

        int result = 1;
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        String start = "26/08/2017";
        String end = "26/05/2018";
        String home_team = "Arsenal";
        String away_team = "Manchester United";
        String date = "2/12/2017";


        manageleague.League englishLeague = new manageleague.League("English Premier League", start, end);
        englishLeague.addTeams(home_team);  //Call test method
        englishLeague.addTeams(away_team);
        englishLeague.addMatch(home_team, away_team, date);

        assertTrue("No match was added", englishLeague.getList_of_teams().size() == result);
        assertThat("Date was not set",df.format(englishLeague.getList_of_matches().get(0).getMatch_date()), is(date));
    }
}
