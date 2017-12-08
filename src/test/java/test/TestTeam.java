package test;

import manageleague.Team;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTeam {

    public TestTeam() {
    }

    /**
     * Test Constructor method for {@link manageleague.Team#Team(String)}.
     */
    @Test
    public void testTeamConstruct() {
        String name = "Real Madrid FC";
        manageleague.Team team = new Team(name);

        assertThat("Couldn't create team",team.getName(), is(name));
    }

    /**
     * Test method for {@link Team#addDraw()}.
     */
    @Test
    public void testAddDraw() {
        String name = "Real Madrid FC";
        int result = 1;
        manageleague.Team team = new Team(name);
        for(int i = 0; i < result; i++){
            team.addDraw();
        }

        assertThat("didnt add drawn match to team",team.getDrawn(), is(result));
    }

    /**
     * Test method for {@link Team#addLoss()}}.
     */
    @Test
    public void testAddLoss() {
        String name = "Real Madrid FC";
        int result = 0;
        manageleague.Team team = new Team(name);
        for(int i = 0; i < result; i++){
            team.addLoss();
        }

        assertThat("didnt add lost match to team",team.getLost(), is(result));
    }

    /**
     * Test method for {@link Team#addWin()}}.
     */
    @Test
    public void testAddWin() {
        String name = "Real Madrid FC";
        int result = 4;
        manageleague.Team team = new Team(name);
        for(int i = 0; i < result; i++){
            team.addWin();
        }

        assertThat("didnt add won match to team",team.getWin(), is(result));
    }
}
