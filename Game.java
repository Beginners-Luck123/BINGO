import java.util.ArrayList;


public class Game {
public static void main(String[] args)
  {
	int num;
	int[][] card1 = new int[5][5];
	boolean win1 = false;
	
	ArrayList<Integer> picks = new ArrayList<Integer>();
	for(int i = 1; i <= 75; i++)
		picks.add(i);
	
	cardMaker(card1);
	while(!win1)
	{
		num = picks.remove((int)(Math.random()*(picks.size())));
  
		System.out.println("The number called is: " + num);
		check(card1, num);
		output(card1);
		win1 = isWinner(card1);
	}
  }
  public static void cardMaker(int[][] card)
    {
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	for(int r = 0; r < 5; r ++)
	{
		for(int i = 1; i <= 15; i++)
		{
			list.add(15*r+i);
		}
		for(int c = 0; c< 5; c++)
		{
			card[r][c] = list.remove((int)(Math.random()*(list.size())));
	    }
		list.clear();
	}
	 card[2][2] = 0;
  }

 
  public static void output(int[][] card)
  {
	  for(int r = 0; r < 5; r++)
	  {
		  for(int c = 0; c < 5; c++)
		  {
			  System.out.print(card[r][c] + "\t");
		  }
		  System.out.println();
		  }
	}
  public static void check(int[][] card, int target)
  {
	  for(int r = 0; r < 5; r++)
	  {
		  for(int c = 0; c < 5; c++)
		  {
			 if(card[r][c] == target)
			 {
				 card[r][c] = 0;
			 }
		  }
		
	  }
  }

public static boolean isWinner(int[][] card)
{
	int sum = 0;
	//check the rows
	  for(int r = 0; r < 5; r++)
	  {
		 sum = 0;
		  for(int c = 0; c < 5; c++)
		  {
			 sum += card[r][c];
		  }
		  if(sum == 0)
			  return true;
}
	  for(int c = 0; c < 5; c++)
	  {
		 sum = 0;
		  for(int r = 0; r < 5; r++)
		  {
			 sum += card[r][c];
		  }
		  if(sum == 0)
			  return true;
      } 
sum = card[0][0] + card[1][1] + card [2][2] + card[3][3] + card[4][4];
if (sum == 0)
	return true;

sum = card[0][4] + card[1][3] + card [2][2] + card[3][1] + card[4][0];
if (sum == 0)
	return true;
return false;
}
}

