/*
* Maths.java
* by Deniss Strods
* @ 7.12.2014 - ***
*/
//Creating class
import java.util.Scanner;
public class MathsApp{
	//Main engine
	public static void main(String args[]){
		//Variables
		int times, total, user_door, open_door, other_door, prize_door;
		char userReply, startUserReply;
		String msg;
		int changeLose;
		int changeWin;
		int lose;
		int win;
		boolean sw;
		//Creating instances
		Maths myMaths = new Maths();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Computer generated?(y) User input?(any other key): ");
	    startUserReply = keyboard.next().charAt(0);
			if (startUserReply == 'y'){
				//STARTING FIRST SCENARIO
				//1)	Prompt the user for input by requesting how many times they would like to run the simulation.
				System.out.print("Times to run the simulation?(COMP): ");
				//2)	Store how many times to run the simulation.
				times = keyboard.nextInt();
				//sets times in the instance Maths
				myMaths.setTimes(times);
				//Running Simulation with random choices
				myMaths.computeBot();
			}
			else{
				//STARTING SECOND SCENARIO
				//1)	Prompt the user for input by requesting how many times they would like to run the simulation.
				System.out.print("Times to run the simulation?(USER): ");
				times = keyboard.nextInt();
				//Begining main loop
				for(int i=0; i<times; i++){
					//b.	Prompt the user for input by requesting that they choose a door that they think the car is behind.
					System.out.println(" Please choose the door(1, 2 or 3): ");
					//c.	Store the user’s choice.
					user_door = keyboard.nextInt();
					//Fail Safe
					while(user_door != 1 && user_door != 2 && user_door != 3){
						System.out.println("INCORRECT INPUT!");
						System.out.println("Please choose the door(1, 2 or 3): ");
						user_door = keyboard.nextInt();
					}
					myMaths.setUser_door(user_door);
					//running compute method from other class
					//a.	Randomly associate a car with one of the three doors and associate a goat with each of the remaining two doors.
					myMaths.compute();
					//GETTING VALUES
					open_door = myMaths.getOpen_door();
					prize_door = myMaths.getPrize_door();
					other_door = myMaths.getOther_door();

					//TELLING BEHIND WICH DOOR ARE GOATS
					/*
					d.	No matter what door the user chooses, one of the remaining doors will definitely be associated with a goat.
					Output to the user a message that
					‘Door X has a goat behind it! Would you like to switch your choice to the other remaining door?’.
					Here X should refer to one of the actual door numbers behind which is a goat
					(but never the door that the user initially chose).
					*/
					System.out.println("Door " + open_door + " has a goat behind it!");
    				System.out.println("You selected door number " + user_door);
    				System.out.println();
					//Switch door??
    				System.out.println("Would you like to switch your choice to the other remaining door?(y/n)? ");
    				userReply = keyboard.next().charAt(0);
						//FAILSAFE FOR INCORRECT INPUT
						while(userReply != 'y'&& userReply != 'n'){
							System.out.println("INCORRECT INPUT!");
							//prompting question switch or not??
							System.out.println("Would you like to switch the door(y/n)? ");
    						userReply = keyboard.next().charAt(0);
						}
						if(userReply == 'y'){
							user_door = other_door;
							sw = true;
						}
						else if(userReply == 'n'){
							sw = false;
						}
					//e.	Output whether or not the user has won the car.
    				System.out.println("The prize is behind door number: " + prize_door);
    				//CONCLUSIONS
    				//f.	Record whether or not the user changed their mind and whether or not they won the car.
    				myMaths.computeResult();
    				msg = myMaths.getMsg();
    				System.out.println(msg);
    				System.out.println();
					//END OF MAIN LOOP
				}
	//END OF START IF STATMENT
			}
			//Getters for the result
			//4)	Present the following data:
			changeLose = myMaths.getChangeLose();
			changeWin = myMaths.getChangeWin();
			lose = myMaths.getLose();
			win = myMaths.getWin();
			total = myMaths.getTotal();
			//a.	Total number of simulation runs
			System.out.println("Games played: " + times);
			//c.	Total number of wins when the user doesn’t change their mind
			System.out.println("Games without switch won: " + win);
			//b.	Total number of wins when the user changes their mind
			System.out.println("With switch won: " + changeWin);
			System.out.println("Games without switch lost: " + lose);
			System.out.println("With change lose: " + changeLose);
	}
}