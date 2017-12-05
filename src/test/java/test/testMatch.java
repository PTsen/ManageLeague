package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

import manageleague.League;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;
import static org.junit.Assert.*;
public class testMatch {

    @Test
    void testSetScores() {
       manageleague.Match match = new manageleague.Match("Arsenal", "Liverpool", "10/10/2017" );
        match.SetScores(1,0);
        if(match.DeterminePoints()!= ) {
            fail("Wrong score");

        }
}
