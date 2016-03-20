/*
* MathsApp.java
* by Deniss Strods
* @ 7.12.2014 - ***
*/
//start class
 import java.util.Random;//Using this to generate random bolean
public class Maths{

//declare variable
	private int user_door, open_door, other_door, prize_door;
	private boolean sw;
	private int changeLose;
	private	int changeWin;
	private	int lose;
	private int win;
	private int times;
	private int total;
	private String msg;

	//Creating an instance
	Random rand = new Random();
//constructor
	public Maths(){
		msg = "";
	    user_door = 0;
	    open_door = 0;
	    other_door = 0;
        prize_door = 0;
        changeLose = 0;
		changeWin = 0;
		total = 0;
		times = 0;
		lose = 0;
		win = 0;
		sw = true;

	}
	//setting setter(prompting from user what door??)
	public void setUser_door(int user_door){
		this.user_door = user_door;
	}
	public void setTimes(int times){
		this.times = times;
	}
	//compute method
	//a.	Randomly associate a car with one of the three doors and associate a goat with each of the remaining two doors.
	public void compute(){
	//Getting prize door first
	prize_door = (int)(Math.random()*3)+1;

    //(Initializing it of zero so the loop would run)
    open_door = prize_door;

	//Adding exeptions to the random number generator
	while(open_door == prize_door||open_door == user_door){
        open_door = (int)(Math.random()*3)+1;
    }

	//(Initializing it of zero so the loop would run)
	other_door = open_door;

	//Adding exeptions to the random number generator
	while (other_door == open_door||other_door == user_door){
        other_door = (int)(Math.random()*3)+1;
    }
	}
	public void computeBot(){
		//STARTING LOOP
		for(int i=0; i<times; i++){
			//GENERATING RANDOM ANSWER
			user_door = (int)(Math.random()*3)+1;
			//ASOCIATING DOORS RANDOMLY
			compute();
			//GENERATING RANDOM ANSWER for swich
			sw = rand.nextBoolean();
			computeResult();
		}
	}
	//f.	Record whether or not the user changed their mind and whether or not they won the car.
	public void computeResult(){
		total = win + changeWin + lose + changeLose;
		if (sw){
			user_door = other_door;
		}

		if(user_door == prize_door){
			msg = "Congratulations, you WON the game!";
			if(sw){
			changeWin++;
			}
			else{
			win++;
			}
		}
		else{
			msg = "I'm sorry but you LOST the game!";
			if(sw){
				changeLose++;
			}
			else{
			lose++;
			}
		}
	}
	//getter
	public int getOpen_door(){
		return open_door;
	}
	public int getPrize_door(){
		return prize_door;
	}
	public int getOther_door(){
		return other_door;
	}
	public boolean getSw(){
		return sw;
	}
	//FOR ANSWERS:
	public int getTotal(){
		return total;
	}
	public int getWin(){
		return win;
	}
	public int getLose(){
		return lose;
	}
	public int getChangeWin(){
		return changeWin;
	}
	public int getChangeLose(){
		return changeLose;
	}
	//MESSAGE OF GAME STATUS
	public String getMsg(){
		return msg;
	}

}