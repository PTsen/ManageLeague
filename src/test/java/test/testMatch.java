package test;

public class testMatch {

    @Test
    void testSetScores() {
        Match match = new Match("Arsenal", "Liverpool", "10/10/2017" );
        match.SetScores(1,0);
        if(match.DeterminePoints()!=2) {
            fail("Wrong age");

        }
    }



}
