package manageleague;

import java.util.Date;
import java.io.Serializable;

public class Match implements Serializable{

    //private fields
    private int score_t1;
    private int score_t2;
    private Team home_team;
    private Team away_team;
    private Date match_date;

    //Constructor method
    public Match(Team team1, Team team2, Date match_date) {
        home_team = team1;
        away_team = team2;
        this.match_date = match_date;
    }

    //Accessors
    public int getScore_t1() {
        return score_t1;
    }

    public int getScore_t2() {
        return score_t2;
    }

    public Team getHome_team() {
        return home_team;
    }

    public Team getAway_team() {
        return away_team;
    }

    public Date getMatch_date() {
        return match_date;
    }

    //Methods
    public void DeterminePoints(){
    	if (this.score_t1 > this.score_t2) {
    		this.home_team.addWin();
    		this.away_team.addLoss();
    		
    	} else {
    		if (this.score_t1 == this.score_t2) {
    			this.home_team.addDraw();
    			this.away_team.addDraw();
    			
    		} else {
    			this.home_team.addLoss();
    			this.away_team.addWin();
    			
    		}
    		
    	}
    }

    public void setScores(int score_t1, int score_t2) {
        this.score_t1 = score_t1;
        this.score_t2 = score_t2;
        DeterminePoints(); //Might be better to leave this out of the function
    }
}
