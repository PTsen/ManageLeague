package manageleague;

import java.io.Serializable;

public class Team implements Serializable {


	private int position;
    private int drawn;
    private int lost;
    private int win;
    private int played;
    private int goal_diff;
    private int points;
    //Private fields
<<<<<<< HEAD
    private String name;
	
	
	public Team(String Namme){ 	
	}
	
=======
>>>>>>> be0f67336547caa7b6daef8afdde5095318ad541
    public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getDrawn() {
		return drawn;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public int getGoal_diff() {
		return goal_diff;
	}

	public void setGoal_diff(int goal_diff) {
		this.goal_diff = goal_diff;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

<<<<<<< HEAD
	public void addWin(){
	     this.win + 1;
	}
	public void addLoss(){
		 this.loss +1;
	}
	public void addDraw(){
	     this.draw +1;  
	}
	
=======
	private String name;
	private int position;
    private int drawn;
    private int lost;
    private int win;
    private int played;
    private int goal_diff;
    private int points;

    public Team(String name) {
    	this.name = name;
    	
    }


>>>>>>> be0f67336547caa7b6daef8afdde5095318ad541
}
