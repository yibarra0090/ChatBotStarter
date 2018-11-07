import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot1
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;
	public String name1;
	public String name2;
	public String adj1;
	public String bodypart;
	public String pronoun1;
	public String pronoun2;
	public String gender;
	public String food;
	public String country;
	public String number1;
	public String number2;
	public String verb;


	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			//System.out.println(getResponse(statement));
			if (statement.equals("1"))
			{
				System.out.println("What is your name?");
				name1 = in.nextLine();
				System.out.println("Are you a girl, boy, or neither?");
				gender= in.nextLine();
				if (gender.equals("girl") || gender.equals("Girl")) {
					pronoun1 = "Her";
					pronoun2 = "She";
					System.out.println("Ok! Can I have an adjective?");
				}
				if (gender.equals("boy") || gender.equals("Boy")) {
					pronoun1 = "His";
					pronoun2 = "He";
					System.out.println("Ok! Can I have an adjective?");
				}
				if (gender.equals("neither") || gender.equals("Neither")) {
					pronoun1 = "Them";
					pronoun2 = "They";
					System.out.println("Ok! Can I have an adjective?");

				}
				//System.out.println("Ok! Can I have an adjective?");
				adj1 = in.nextLine();
				System.out.println("Okay, now I need a boy name.");
				name2 = in.nextLine();
				System.out.println("Give me a body part.");
				bodypart= in.nextLine();
				System.out.println("Okay "+name1+"! Here's the story!");
				System.out.println(madLib1(name1, name2, adj1, bodypart));
			}
			if (statement.equals("2"))
			{
				System.out.println("Good choice! Give me a food.");
				food= in.nextLine();
				System.out.println("Now, give me the name of a country.");
				country= in.nextLine();
				System.out.println("Give me a number.");
				number1= in.nextLine();
				System.out.println("Enter in a boy name.");
				name1= in.nextLine();
				System.out.println("Give me an adjective.");
				adj1= in.nextLine();
				System.out.println("Now, I need a verb.");
				verb= in.nextLine();
				System.out.println("Okay, a girl name please.");
				name2= in.nextLine();
				System.out.println("Finally, give me another number.");
				number2= in.nextLine();
				System.out.println("Here's the story!" + madLib2(food, country, number1, name1, adj1, verb, name2, number2 ));

			}


		}



	}
	public String madLib1(String name1, String name2, String adj1, String bodypart) {
		return "One Friday night, " + name1 + " was walking down a "+adj1+" road." + pronoun2 + " heard something suspicious, and stopped to turn around. When" + pronoun2.toLowerCase()+" turned around, " + pronoun2.toLowerCase()+" saw it was" +pronoun1.toLowerCase()+" friend " + name2+ ". "+name2+" ran up to " +name1+ " and collapsed on the ground, and his "+bodypart+" fell off!";
	}
	public String madLib2 (String food, String country, String number1, String name1, String adj1, String verb, String name2, String number2) {
		return "Once upon a time, there was the Kingdom of " + food + " located in the country of " + country +". In that Kingdom lived "+ number1 +" people, and the most important of them all was Prince " +name1+ ". Prince " + name1 +" was " + adj1 +" and handsome, and he loved his kingdom. The future of the kingdom of " + food +" was in his hands, and all he needed was a princess to help him rule. One day, he was " + verb +" down the street, when he spotted the most beautiful girl he had ever seen. He asked her for her name, which was " + name2 +". Then, he asked for her hand in marriage, and she gladly accepted. They ended up having " + number2 +" kids and living happily ever after.";
	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hi, I'm LibBot. I tell you stories based on information that you give me. There are 5 types of stories. To get started, pick a number from 1-5.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	//public String getResponse(String statement)
	//{
		//String response = "";
		
		//if (statement.length() == 0)
		//{
			//response = "Say something, please.";
		//}

		//else if (findKeyword(statement, "1") >= 0)
		//{
			//response = "Give me a name.";
		//}
		
		//else if (findKeyword(statement, "levin") >= 0)
		//{
			//response = "More like LevinTheDream, amiright?";
			//emotion++;
		//}
		//else if (findKeyword(statement, "folwell") >= 0)
		// {
			//response = "Watch your backpacks, Mr. Folwell doesn't fall well.";
			//emotion++;
		///}
		//else if (findKeyword(statement, "goldman") >= 0)
		//{
			//response = "Go for the gold, man.";
			//emotion++;
		//}

		// Response transforming I want to statement
		//else if (findKeyword(statement, "I want to", 0) >= 0)
		//{
			//response = transformIWantToStatement(statement);
		// }
		//else if (findKeyword(statement, "I want",0) >= 0)
		//{
			//response = transformIWantStatement(statement);
		//}
		//else
		//{
			//response = getRandomResponse();
		//}
		
		//return response;
	//}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
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
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
