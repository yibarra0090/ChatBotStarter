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
	public String birthday;
	public String item;
	public String profession;
	public String response;
	public String city;
	public String day;
	public String direction;
	//make the players name universal



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
					System.out.println("Okurrr! Can I have an adjective?");
				}
				if (gender.equals("boy") || gender.equals("Boy")) {
					pronoun1 = "His";
					pronoun2 = "He";
					System.out.println("Okurrr! Can I have an adjective?");
				}
				if (gender.equals("neither") || gender.equals("Neither")) {
					pronoun1 = "Them";
					pronoun2 = "They";
					System.out.println("Okurrr! Can I have an adjective?");

				}
				//System.out.println("Ok! Can I have an adjective?");
				adj1 = in.nextLine();
				if (adj1.substring(0,1).equals("a") || adj1.substring(0,1).equals("e") || adj1.substring(0,1).equals("i") || adj1.substring(0,1).equals("o"))
				{
					adj1= "an " + adj1 + " ";
				}
				else
				{
					adj1= "a " + adj1 + " ";
				}
				System.out.println("Okay, now I need a boy name.");
				name2 = in.nextLine();
				System.out.println("Give me a body part.");
				bodypart= in.nextLine();
				System.out.println("Okay "+name1+"! Here's the story! ");
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
				System.out.println("Here's the story! " + madLib2(food, country, number1, name1, adj1, verb, name2, number2 ));

			}
			if (statement.equals("3"))
			{
				System.out.println("Enter in a girl name.");
				name1= in.nextLine();
				System.out.println("Enter in a number 1-100");
				number1= in.nextLine();
				System.out.println("Give me the infinitive of a verb.");
				verb= in.nextLine();
				System.out.println("Give me a day of the week.");
				day= in.nextLine();
				System.out.println("Give me a direction, like left, right, etc.");
				direction = in.nextLine();
				System.out.println("Enter in an adjective.");
				adj1= in.nextLine();
				if (adj1.substring(0,1).equals("a") || adj1.substring(0,1).equals("e") || adj1.substring(0,1).equals("i") || adj1.substring(0,1).equals("o"))
				{
					adj1= "an " + adj1 + " ";
				}
				else
				{
					adj1= "a " + adj1 + " ";
				}
				System.out.println("Lastly, give me the name of a music artist.");
				name2= in.nextLine();
				System.out.println("Here it is! " + madLib3(name1, number1, verb, day, direction, adj1, name2));



			}
			if (statement.equals("4"))
			{
				System.out.println("The story of mischief gone wrong. Enter in a boy name.");
				name1= in.nextLine();
				System.out.println("Enter in another boy name.");
				name2= in.nextLine();
				System.out.println("What is the name of your favorite city?");
				city = in.nextLine();
				System.out.println("In what country is that city located?");
				country=in.nextLine();
				System.out.println("Ok! Give me a food you hate.");
				food= in.nextLine();
				System.out.println("Here it is! " + madLib4(name1, name2, city, country, food));
									}
			if (statement.equals("5"))
			{
				System.out.println("This one's a little weird. When is your birthday (in terms on month and day)?");
				birthday = in.nextLine();
				System.out.println("Give me an adjective.");
				adj1 = in.nextLine();
				if (adj1.substring(0,1).equals("a") || adj1.substring(0,1).equals("e") || adj1.substring(0,1).equals("i") || adj1.substring(0,1).equals("o"))
				{
					adj1= "an " + adj1 + " ";
				}
				else
				{
					adj1= "a " + adj1 + " ";
				}
				System.out.println("Give me an item.");
				item= in.nextLine();
				System.out.println("Enter in a profession.");
				profession= in.nextLine();
				System.out.println("Okay, now give me a verb.");
				verb= in.nextLine();
				System.out.println("What's the name of your best friend?");
				name1= in.nextLine();
				//consider adding specific pronouns for the best friend
				System.out.println("Here ya go! " + madLib5(birthday, adj1, item, profession, verb, name1));
			}
			System.out.println(" ");
			System.out.println("What did you think of the story?");
			response = in.nextLine();



		}




	}
	public String madLib1(String name1, String name2, String adj1, String bodypart) {
		return "One Friday night, " + name1 + " was walking down "+adj1+" road." + pronoun2 + " heard something suspicious, and stopped to turn around. When" + pronoun2.toLowerCase()+" turned around, " + pronoun2.toLowerCase()+" saw it was" +pronoun1.toLowerCase()+" friend " + name2+ ". "+name2+" ran up to " +name1+ " and collapsed on the ground, and his "+bodypart+" fell off!";
	}
	public String madLib2 (String food, String country, String number1, String name1, String adj1, String verb, String name2, String number2) {
		return "Once upon a time, there was the Kingdom of " + food + " located in the country of " + country +". In that Kingdom lived "+ number1 +" people, and the most important of them all was Prince " +name1+ ". Prince " + name1 +" was " + adj1 +" and handsome, and he loved his kingdom. The future of the kingdom of " + food +" was in his hands, and all he needed was a princess to help him rule. One day, he was " + verb +" down the street, when he spotted the most beautiful girl he had ever seen. He asked her for her name, which was " + name2 +". Then, he asked for her hand in marriage, and she gladly accepted. They ended up having " + number2 +" kids and living happily ever after.";
	}
	public String madLib3(String name1, String number1, String verb, String day, String direction, String adj1, String name2)
	{
		return "There was once this girl, named "  + name1 + ". She was " +number1+ " years old, and loved to "+ verb +". She hoped to become famous one day. However, before she could even have a shot at living her dream, a nightmare would happen instead. It was an early " +day+" morning, when she suddenly awoke. She found that she could not move, and fear started take over her body. She looked "+direction+" , and saw "+adj1+" sleep paralysis demon. "+name1+" tried to scream, but she couldn’t. All of a sudden, the sleep paralysis demon started speaking to her. It said ‘Yurrrr. I am here to terrorize you and to let you know that you will never wake up again.’ Then, it started singing a " +name2+" song. This scared " +name1+" so much that she passed out and fell back asleep." ;
	}
	public String madLib4(String name1, String name2, String city, String country, String food)
	{
		return name1 +" and " +name2 +" are identical twins that live in "+ city + ", " + country +". They go to the same high school, and take the same classes. One day, " + name1 + " and " + name2 +" decided to play a prank on their school and switch schedules for a day. Anyways, it's not likely anything bad would happen. SIKE! " + name1 +"'s girlfriend ended up breaking up with him that day, and " +name2 +" would have no idea how to tell his brother that his girlfriend was done with him. Yet, he'd never have to. " + name1 +", who is allergic to " +food+", accidentally some them as " +name2+"'s best friend decided to bake cookies with " +food+" in them. " +name1+" was unaware, and ended up dying.";
	}
	public String madLib5(String birthday, String adj1, String item, String profession, String verb, String name1)
	{
		return "It is your birthday, " + birthday + " . You decide to treat yourself, and you buy " +adj1 + item + ". You are very happy with your purchase, and you take it home. You start to fall in love with your " + item + ", so much that your friends and family start to become worried about you. You even quit your job as a " + profession + " so that you can stay home and " + verb + " with the " + item + " all day. You have become madly obsessed with it. One day, your best friend " + name1 + " comes over. You show them your new " + item + " and they compliment it. You say thanks, and you go to the bathroom and tell them not to touch it. However, when you return from the bathroom, your eyes lay upon an enraging sight- " + name1 + " has their hands all over it! You flip out, and kill your best friend.";
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
	private String storyFeedback(String response)
	{
		response= response.trim();
		return "rdjgfkfv";

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
