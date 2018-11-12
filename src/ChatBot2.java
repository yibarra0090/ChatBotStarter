import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot2
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int win = 0;
	private String[] gameWordBankCSA = {"Chat Bot", "AP CSA", "Mr Levin", "Constructor", "Shapes Lab", "Method Signature"};
	private String[] gameWordBankStarWars = {"The High Ground", "Luke Skywalker", "Darth Maul", "501st Legion", "Trade Federation", "Grand Moff Tarkin"};
	private String[] gameWordBankPresidents = {"Barack Obama", "George Washington", "Ulysses Grant", "Harry Truman", "Theodore Roosevelt", "Ronald Reagen"};


	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equalsIgnoreCase("no"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));
		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "You ready to play some Hangman?";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Hello, anyone there?";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "See you around!";
		}

		else if (findKeyword(statement, "yes") >= 0)
		{
			hangmanGame(gameWordBankCSA);
		}
		else
		{
			response = "Ok.";
		}
		
		return response;
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	public String getEndResponse ()
	{
		Random r = new Random ();
		if (win == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (win < 0)
		{	
			return lossResponses [r.nextInt(lossResponses.length)];
		}	
		return victoryResponses [r.nextInt(victoryResponses.length)];
	}
	
	public String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	public String [] lossResponses = {"Ouch. RIP that guy.", "Another one bites the dust.",
			"Might want to dust off your noggin a bit next time.", "I outsmarted you this time! Hah!"};
	public String [] victoryResponses = {"Oh, fiddlesticks! I lost!", "You technically saved a life today. Bless your soul.",
			"Wow, look at your beaming IQ!", "If I could, I'd give you a cookie."};

	public void hangmanGame(String[] args)
	{
		win = 0;
		String pickCat = "";
		String chosenCat = "";
		String chosenWord = "";
		Scanner category = new Scanner(System.in);
		System.out.println("Choose from the following categories: CSA, Star Wars, US Presidents");
		pickCat = category.nextLine();
		if(pickCat.equalsIgnoreCase("US Presidents"))
		{
			chosenWord = gameWordBankPresidents[(int)(Math.random()*gameWordBankPresidents.length)];
		} else
		if(pickCat.equalsIgnoreCase("CSA"))
		{
			chosenWord = gameWordBankCSA[(int)(Math.random()*gameWordBankCSA.length)];
		} else
		if(pickCat.equalsIgnoreCase("Star Wars"))
		{
			chosenWord = gameWordBankStarWars[(int)(Math.random()*gameWordBankStarWars.length)];
		} else
		{
			System.out.println("Sorry, that's not a valid choice. Please pick from the given.");
			pickCat = category.nextLine();
		}
		String hangmanWrongStr = "";
		System.out.println("Alright, great! Take your first guess.");
		String[] hangmanWrongArray = {"H", "A", "N", "G", "M", "A", "N x_x"};
		String[] chosenWordArray;
		chosenWordArray = new String[chosenWord.length()];
		for(int i = 0; i < chosenWord.length(); i++)
		{
			chosenWordArray[i] = chosenWord.substring(i, i+1);
		}
		String[] hiddenWordArray;
		hiddenWordArray = new String[chosenWord.length()];
		for(int i = 0; i < chosenWord.length(); i++)
		{
			if(!chosenWordArray[i].contains(" "))
			{
				hiddenWordArray[i] = "_";
			} else

			{
				hiddenWordArray[i] = " ";
			}
		}
		int wrongCount = -1;
		int changedChars = 0;
		String guess = "";
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < hiddenWordArray.length; i++)
		{
			System.out.print(hiddenWordArray[i]);
		}
		while(!Arrays.equals(hiddenWordArray, chosenWordArray ) && !hangmanWrongStr.equals("HANGMAN x_x"))
		{
			guess = input.nextLine();
			if(guess.contains("quit"))
			{
				while(!guess.equalsIgnoreCase("yes") && !guess.equalsIgnoreCase("no"))
				{
					System.out.println("Are you sure you want to quit? Yes or No");
					guess = input.nextLine();
					if(guess.equalsIgnoreCase("yes"))
					{
						System.out.println("Do you want to play again?");
						return;
					} else

						if(guess.equalsIgnoreCase("no"))
					{
						System.out.println("Ok, moving on.");
					} else

						if(!guess.equalsIgnoreCase("yes") && !guess.equalsIgnoreCase("no"))
					{
						System.out.println("Yes or No only, please.");
					}
				}
			} else

			if(guess.length() > 1)
			{
				System.out.println("Please guess with a single-character response.");
			} else

			{
				for(int j = 0; j < hiddenWordArray.length; j++)
				{
					if(chosenWordArray[j].equalsIgnoreCase(guess))
					{
						hiddenWordArray[j] = chosenWordArray[j];
						changedChars++;
					}
				}
				if(changedChars == 0)
				{
					wrongCount++;
					hangmanWrongStr += hangmanWrongArray[wrongCount];
				}
			}
			for(int k = 0; k < hiddenWordArray.length; k++)
			{
				System.out.print(hiddenWordArray[k]);
			}
			System.out.println(" " + hangmanWrongStr);
			changedChars = 0;
		}
		if(Arrays.equals(hiddenWordArray, chosenWordArray))
		{
			win++;
			System.out.println(getEndResponse());
		}
		if(hangmanWrongStr.equals("HANGMAN x_x"))
		{
			win--;
			System.out.println(getEndResponse());
		}
		System.out.println("Do you want to play again?");
	}
}
