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

import org.junit.Test;
import static org.junit.Assert.*;
public class testMatch {

    @Test
    void testMatchConstruct() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df1 = new SimpleDateFormat("dd/MM/yy");
        DateFormat df2 = new SimpleDateFormat("d/M/yyyy");
        DateFormat df3 = new SimpleDateFormat("d/M/yy");
        String name1 = "Arsenal";
        String name2 = "Liverpool";
        String date = "10/10/2017";
        

        //manageleague.Team team1 = new Team(name2);
        //manageleague.Team team2 = new Team(name1);

        manageleague.Match match = new manageleague.Match(name1, name2, date);
        match.SetScores(1,0);

        assertThat("name team 1", match.getHome_team().getName(), is(name1));
        assertThat("name team 2", match.getAway_team().getName(), is(name2));
        assertThat("Date match", df.format(match.getMatch_date()), is(date));

        }

    @Test
    void testSetScores(){

    }



}

