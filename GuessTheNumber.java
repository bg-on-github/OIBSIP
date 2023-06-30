import javax.swing.*;
import java.util.Random;

class GuessTheNumber
{
	public static void main(String args[])
	{
		String a, high_low_msg="", exit_msg="";
		int points = 0, lives = 3, round = 0, random = 0, rg = 0, wg = 0, g=0; 
		//a stores the String input from the user
		//g stores the guess made by the user
		//rg stores the number of right guesses, wg stores the number of wrong guesses
		//round stores the current round number
		//lives stores the total number of lives the player has
		JOptionPane.showMessageDialog(null, "           Welcome to\n  GUESS THE NUMBER!", "                    GUESS THE NUMBER", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "1. You get five chances to guess the randomly\n    generated number\n2. The scoring scheme is as follows:\n    +5 for a correct guess at first chance\n    +4 for a correct guess at second chance\n    +3 for a correct guess at third chance\n    +2 for a correct guess at fourth chance\n    +1 for a correct/incorrect guess at fifth chance\n3. Points will be given after one round is over\n4. Round will be ended if input is outside the range specified\n5. Three lives are available for three out-of-range input mistakes\n6. The game will automatically end if all lives are lost\n=================PRESS OK TO START=================", "                                                             RULES", JOptionPane.INFORMATION_MESSAGE);
		int min, max;
		Random r = new Random();
		do
		{
			min = r.nextInt(50);
		    max = r.nextInt(50)+50;
			round++;
			random = r.nextInt(max-min+1) + min;
			a = JOptionPane.showInputDialog(":::::::::::::::::::::ROUND "+round+":::::::::::::::::::::\nA number has been generated randomly\nbetween "+min+" and "+max+"!\nEnter your guess (or press 'Cancel' to exit):", "0");
			if (a!=null)
			{
				try
				{
					g = Integer.parseInt(a);
				}
				catch(NumberFormatException e)
				{
				}
				if (g == random)
				{
					points+=5;
					rg++;
				}
				else
				{
					if((g>max)||(g<min))
					{
						wg++;
						lives--;
						JOptionPane.showMessageDialog(null, "INVALID!\n1 LIFE LOST!\nROUND IS ENDING...", "                               INVALID", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						int z = 5;
						for (;((g!=random)&&(z>1));--z)
						{
							wg++;
							if(g>random+10)
								high_low_msg="Too high! Try again!";
							else if(g>random)
								high_low_msg="High, but close! Try again!";
							else if(g<random-10)
								high_low_msg="Too low! Try again!";
							else if(g<random)
								high_low_msg="Low, but close! Try again!";
							a = JOptionPane.showInputDialog(high_low_msg);
							try
							{
								g = Integer.parseInt(a);
							}
							catch(NumberFormatException e)
							{
								lives--;
								JOptionPane.showMessageDialog(null, "INVALID!\n1 LIFE LOST!\nROUND IS ENDING...", "                                INVALID", JOptionPane.WARNING_MESSAGE);
								break;
							}
							if((g>max)||(g<min))
							{
								wg++;
								lives--;
								JOptionPane.showMessageDialog(null, "INVALID!\n1 LIFE LOST!\nROUND IS ENDING...", "                                INVALID", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
						if((g<max)||(g>min))
						{
							points+=z;
							if (g==random) rg++;
							else wg++;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "The number was "+random+".\nGood luck for the next round!\nPOINTS : "+points+"\nLIVES : "+lives+"\nRIGHT GUESSES :"+rg+"\nWRONG GUESSES : "+wg, "                           ROUND OVER", JOptionPane.INFORMATION_MESSAGE);
			}
		}while(a!=null && lives>0);
		if (lives==0)
			exit_msg = "                  You ran out of lives!";
		else if (a==null)
			exit_msg = "                    You chose to exit!";
		JOptionPane.showMessageDialog(null, exit_msg+"\n                    See you next time!", "                           GAME OVER", JOptionPane.PLAIN_MESSAGE);
	}
}