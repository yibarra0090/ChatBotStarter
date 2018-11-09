import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot3 {
    private String [] riddles = {"What is often returned but is never borrowed?", "I have cities but no houses, moutains but no trees, and water but no fish. What am I?", "What do you call a three humped camel?", "I’m often running yet I have no legs. You need me but I don’t need you. What am I?", "What ten letter word starts with gas?", "What is 3/7 chicken, 2/3 cat and 2/4 goat?"};
    private String [] corrAnswers = {"Thanks", "A map", "Pregnant", "Water", "Chicago"};
    int ran = (int) ((Math.random() * 4));
    String randomRid = riddles[ran];
    String randomAns = corrAnswers[ran];
    public void chatLoop(String statement) {
        Scanner in = new Scanner(System.in);
        System.out.println(getGreeting());
        while (!statement.equals("Bye")) {
            statement = in.nextLine();
            //getResponse handles the user reply
            System.out.println(getResponse(statement));
        }
    }
    public String getGreeting() {
        int ran = (int) ((Math.random() * 4));
        return "Hi, this is Joke/Riddle Bot, want to hear a joke/riddle?";
    }

    public String getResponse(String statement) {
        Scanner in = new Scanner(System.in);
        String response = "";
        if (statement.length() == 0) {
            response = randomAngryResponses[(int)(Math.random() * 3)];
        } else if (findKeyword(statement, "yes") >= 0) {
            System.out.println("Let's go!");
            System.out.println("Okay here we go:" + "" + " " + randomRid);
            statement = in.nextLine();
            while((findKeyword(statement, randomAns) < 0)) {
                if (findKeyword(statement, randomAns) < 0) {
                    System.out.println(randomWrongResponse[(int) ((Math.random() * 3))]);
                    statement = in.nextLine();
                }
            }

            response = randomHappyResponses[(int)(Math.random() *3)];
        } else{
            response = randomAngryResponses[(int)(Math.random() * 3)];;
        }
        return response+""+" "+"Would you like another joke?";
    }
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformAnswerToStatement(String statement)
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
		int psn = findKeyword (statement,randomAns, 0);
		String restOfStatement = statement.substring(psn + randomAns.length()).trim();
		return "Are you sure the answer is " + restOfStatement + "?";
	}
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
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
	private String [] randomWrongResponse = {"Uhh, are you sure", "No, try again", "Not funny, try again", "Seriously?"};
	private String [] randomAngryResponses = {"Bahumbug.", "Okay, bye then!", "The rage consumes me!"};
	private String [] randomHappyResponses = {"You got it!", "Yay!", "That's it!"};
}
