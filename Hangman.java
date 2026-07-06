//sem-4 java microproject

//created by Pushti Maniyar(216490316027) 

//Topic : Hangman game

//description : Guess the word
//              After 6 wrong attempts the man will hange on gallows and you will lose

import java.util.Random;
import java.util.Scanner;

class Hangman
{
	public static void main(String args[])
	{
		System.out.println("							Hangman Game									");
		System.out.println("");
		
		//The words array
		String words[] = {"avenue","awkward","buffalo","information","technology","awarness","crypt","cycle","buzzing","funny","galaxy","jackpot","jazzy","jogging","jumbo","lucky","luxury","matrix","megahertz","microwave","oxygen","pixel","pizza","queue","quiz","scratch","staff","strength","subway","wave","science","social","maths","chemistry","physics","robot","blue","monkey","hello","drawing","happy","smile","face","brother","mother","father","sister","teacher","universe","dance"};
		
		//finding random word
		Random r=new Random();
		int x=r.nextInt(50);
		String word=words[x];
		int slen=word.length();
		
		//the main code
		char w_arr[]= new char[slen+1];
		Scanner s=new Scanner(System.in);
		boolean flag=true;
		for(int i=0; i<slen; i++)
		{
			w_arr[i]=word.charAt(i);
			if(i==0 || i==slen-1)
			{
				System.out.print(w_arr[i]);
			}
			else
			{
				System.out.print("_ ");
			}
		}
		System.out.println("");
		
		char t_arr[]= new char[slen+1];
		t_arr[0]=w_arr[0];
			
		for(int k=1; k<=slen-1; k++)
		{
			t_arr[k]='_';
		}
		t_arr[slen-1]=w_arr[slen-1];
		
		int f=0;
		
		//the main part of game iteration
		while(flag)
		{
			System.out.println("");
			System.out.print("Enter character of your choice which you guessed: ");
			char guess=s.next().charAt(0);
			boolean test=false;
			boolean q=true;
			for(int k=1; k<=slen-1; k++)
			{
				if(w_arr[k]==guess)
				{
					t_arr[k]=guess;
					q=false;
				}
			}
			if(q)
			{
				f++;
			}
			for(int p=0; p<=slen; p++)
			{
				System.out.print(t_arr[p]+" ");
			}
			boolean jo=true;
			for(int i=0; i<=slen-1; i++)
			{
				if(t_arr[i]=='_')
				{
					jo=false;
					break;
				}
			}
			if(jo)
			{
				System.out.println("");
				System.out.println("Congratulations! you won the game...");
				System.out.println("");
				flag=false;
			}
			
			//the hangman animation using symbols :
			switch(f)
			{
				case 1:
					System.out.println("            ");
					System.out.println("  --------  ");
					System.out.println("  |      |  ");
					System.out.println("  O         ");
					break;
				case 2:
					System.out.println("            ");
					System.out.println("  --------  ");
					System.out.println("  |      |  ");
					System.out.println("  O         ");
					System.out.println(" o          ");
					break;
				case 3:
					System.out.println("            ");
					System.out.println("  --------  ");
					System.out.println("  |      |  ");
					System.out.println("  O         ");
					System.out.println(" o o        ");
					break;
				case 4:
					System.out.println("            ");
					System.out.println("  --------  ");
					System.out.println("  |      |  ");
					System.out.println("  O         ");
					System.out.println(" o o        ");
					System.out.println("  |         ");
					break;
				case 5:
					System.out.println("            ");
					System.out.println("  --------  ");
					System.out.println("  |      |  ");
					System.out.println("  O         ");
					System.out.println(" o o        ");
					System.out.println("  |         ");
					System.out.println(" o          ");
					break;
				case 6:
					System.out.println("            ");
					System.out.println("  --------  ");
					System.out.println("  |      |  ");
					System.out.println("  O         ");
					System.out.println(" o o        ");
					System.out.println("  |         ");
					System.out.println(" o o        ");
					System.out.println("Ooops! Sorry! you lose the game...");
					System.out.println("The correct word was : "+word);
					flag=false;
					break;
			}
		}
	}
}