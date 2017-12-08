package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import manageleague.League;
import manageleague.Team;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
public class TestMatch {

    @Test
    public void testMatchConstruct() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); //Other date formats have been tested @TestLeague
        String name1 = "Arsenal";
        String name2 = "Liverpool";
        String date = "10/10/2017";
        manageleague.League english_league = manageleague.League.getInstance(); //gain access convertToDate
        english_league.reset();
        Date dateobject;
        dateobject = english_league.convertToDate(date);


        manageleague.Team team1 = new Team(name1);
        manageleague.Team team2 = new Team(name2);

        manageleague.Match match = new manageleague.Match(team1, team2, dateobject);

        assertThat("name team 1", match.getHome_team().getName(), is(name1));
        assertThat("name team 2", match.getAway_team().getName(), is(name2));
        assertThat("Date match", df.format(match.getMatch_date()), is(date));

        }

    @Test
    public void testSetScores(){

        //Case 1
        int score_home = 3;
        int score_away = 0;

        String name1 = "Arsenal";
        String name2 = "Liverpool";
        String date = "10/10/2017";
        manageleague.League english_league = manageleague.League.getInstance(); //gain access convertToDate
        english_league.reset();
        Date dateobject;
        dateobject = english_league.convertToDate(date);


        manageleague.Team team1 = new Team(name1);
        manageleague.Team team2 = new Team(name2);

        manageleague.Match match = new manageleague.Match(team1, team2, dateobject);
        match.SetScores(score_home, score_away);

        assertThat("Home score not set", match.getScore_t1(), is(score_home));
        assertThat("Away score not set", match.getScore_t2(), is(score_away));

        //Case 2
        //int score_home = 0;
        //int score_away = 3;

        //Case 3
        //int score_home = -3;
        //int score_away = 0;

        //Case 4
        //int score_home = 3;
        //int score_away = 0

    }
    //@testDeterminePoints

}


