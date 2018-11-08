import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot4
{
    //emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
    //check
    int correctNum = 0;
    int wrongNum = 0;

    String[] words = new String[20];
    String[] definitions = new String[20];

    String testWord;
    String testDefintion;

    boolean initialize = false;

    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * @param statement the statement typed by the user
     */
    public void chatLoop(String statement)
    {
        Scanner in = new Scanner (System.in);
        System.out.println (getGreeting());

        while (!statement.equals("END"))
        {
            initializeVocab(statement);
            System.out.println("Okay, let's get to quizzing!");
            statement = in.nextLine();
            System.out.println(getResponse(statement));
        }

    }
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, I am QuizBot. I'll help you study. Please type 'END' if you no longer want to speak to me.";
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

        while (initialize = true) {

            testWords(statement);

            if (statement.length() == 0)
            {
                response = "You won't know if you're right unless you try.";
            }

            else if (findKeyword(statement, "What does", 0) >= 0)
            {
                response = transformMeaningStatement(statement);
            }

        }

        return response;
    }

    public void initializeVocab(String statement) {
        Scanner input = new Scanner (System.in);
        statement = input.nextLine();
        int count = 1;

        System.out.println("I can only test a maximum of 20 words at once.");
        System.out.println("When you are finished inputting, please type 'I'm done'.");
        System.out.println("Please input word " + count + ".");
        statement = input.nextLine();
        words[count] = statement;

            while (count <= 21 && !statement.equalsIgnoreCase("I'm done")) {

                System.out.println("Please input the definition of that word. Be careful when typing!");
                statement = input.nextLine();
                definitions[count] = statement;
                count++;

                System.out.println("Please input word " + count + ".");
                statement = input.nextLine();
                words[count] = statement;
            }

            if (count == 21) {
                System.out.println("You've reached the maximum limit of words!");
                initialize = true;
            }

            initialize = true;
    }

    public void testWords(String statement) {
        Scanner input = new Scanner (System.in);
        for (int i = 0; i < 21; i++) {
            if (words[i] != null) {
                System.out.println("What is the meaning of " + words[i] + "?");
                statement = input.nextLine();

                if (statement.equalsIgnoreCase(definitions[i])) {
                    System.out.println(randomCorrectResponse[(int) ((Math.random() * 4 + 1))]);
                    correctNum++;
                } else {
                    System.out.println(randomWrongResponse[(int) ((Math.random() * 4 + 1))]);
                    wrongNum++;
                }
            } else {
                System.out.println("You've completed the quiz!");
            }
        }
    }


    private String transformMeaningStatement(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);

        if (lastChar.equals("?")) {
            statement = statement.substring(0, statement.length() - 1);
        }

        int psn = findKeyword(statement, "What does", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "The definition of the word is";
    }

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

    private String [] randomCorrectResponse = {"That's correct!", "Nice one!", "You got it right!", "Great job!", "Superb!"};
    private String [] randomWrongResponse = {"Hmm...that doesn't seem right.", "That's incorrect.", "Nope, that's not it.", "Maybe you mixed that up with another word?", "Did you make a typo?"};
}
