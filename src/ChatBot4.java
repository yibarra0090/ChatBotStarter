//Janice Lin
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
    /**
     * correctNum and wrongNum keep track of how many questions the user gets right or wrong.
     * This is the "emotion" part of my bot, since it keeps track of the user's score and says something different
     * depending on the how many they answer correctly.
     */
    int correctNum = 0;
    int wrongNum = 0;

    /**
     * These two arrays store the user's input of words and definitions and reference them when quizzing.
     */
    String[] words = new String[20];
    String[] definitions = new String[20];

    /**
     * The boolean initialize keeps the methods in chatLoop running in the correct order.
     * The boolean chatLoop checks if the user wants to stop the program and redirects them back to the main menu
     * if it is false.
     */
    boolean initialize = false;
    boolean chatLoop = true;

    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * Runs the methods initializeVocab(), getResponse(), and feedback().
     * @param statement the statement typed by the user
     */
    public void chatLoop(String statement)
    {
        Scanner in = new Scanner (System.in);
        System.out.println (getGreeting());

        while (!statement.equals("END") && chatLoop)
        {
            initializeVocab(statement);
            System.out.println("Okay, let's get to quizzing! If you want to stop at anytime, just type 'END'.");
            System.out.println("Are you ready?");
            statement = in.nextLine();
            System.out.println(getResponse(statement));
            feedback(statement);
        }

        if (statement.equals("END") || !chatLoop) {
            System.out.println("Now returning to menu...");
            System.out.println("**************");
        }
    }
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, I am QuizBot. I'll help you study.";
    }

    /**
     * Gives a response to a user statement
     * Also randomly generates a positive, neutral, or negative response depending on the number of questions
     * the user gets right.
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";

        while (initialize == true && !statement.equals("END")) {

            testWords(statement);

            if (correctNum > wrongNum) {
                System.out.println(randomPositiveResponse[(int) ((Math.random() * 2 + 1))]);
            } else if (correctNum == wrongNum) {
                System.out.println(randomNeutralResponse[(int) ((Math.random() * 2 + 1))]);
            } else if (correctNum < wrongNum) {
                System.out.println(randomNegativeResponse[(int) ((Math.random() * 2 + 1))]);
            }

            System.out.println("You got " + correctNum + "/" + (correctNum + wrongNum) + " questions right.");
        }

        if (statement.equals("END")) {
            initialize = false;
            chatLoop = false;
            response = "Sorry to see you go!";
        }

        return response;
    }

    /**
     * Initializes the vocabulary and stores the user's inputs into the arrays words and definitions.
     * If the user types "I'm done", the method stops initializing.
     * @param statement the user's statement
     */
    public void initializeVocab(String statement) {
        Scanner input = new Scanner (System.in);
        statement = input.nextLine();
        int count = 1;

        System.out.println("I can only test a maximum of 20 words at once.");
        System.out.println("When you are finished inputting, please type 'I'm done'.");
        System.out.println("Please input word " + count + ".");
        statement = input.nextLine();
        words[count-1] = statement;

            while (count <= 21 && !statement.equalsIgnoreCase("I'm done")) {

                System.out.println("Please input the definition of that word. Be careful when typing!");
                statement = input.nextLine();
                definitions[count-1] = statement;
                count++;

                System.out.println("Please input word " + count + ".");
                statement = input.nextLine();
                words[count-1] = statement;
            }

            if (count == 21) {
                System.out.println("You've reached the maximum limit of words!");
                initialize = true;
            }


            initialize = true;
    }

    /**
     * Method that tests the user on the words they inputted, returning a random correct or incorrect response depending on
     * whether the statement matches what is stored in the array.
     * When all of the words in the array are tested, the bot tells the user that they have completed the quiz.
     * @param statement the user's statement
     */
    public void testWords(String statement) {
        Scanner input = new Scanner (System.in);
        for (int i = 0; i < 21; i++) {
            if (words[i] != null && !words[i].equalsIgnoreCase("I'm done")) {
                System.out.println("What is the meaning of " + words[i] + "?");
                statement = input.nextLine();

                if (statement.length() == 0)
                {
                    System.out.println("You won't know if you're right unless you try.");
                }

                else if (statement.equalsIgnoreCase(definitions[i])) {
                    System.out.println(randomCorrectResponse[(int) ((Math.random() * 4 + 1))]);
                    correctNum++;
                } else {
                    System.out.println(randomWrongResponse[(int) ((Math.random() * 4 + 1))]);
                    wrongNum++;
                }
            } else {
                i = 20;
                initialize = false;
                chatLoop = false;
                System.out.println("**************");
                System.out.println("You've completed the quiz!");
            }
        }
    }

    /**
     * Method that considers the user's thoughts. Includes a transform statement that asks why the user felt that way
     * about the quiz.
     * @param statement the user's statement
     */
    public void feedback(String statement) {
        Scanner input = new Scanner (System.in);
        System.out.println("What did you think of the game?");
        statement = input.nextLine();

        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }

        int psn = findKeyword (statement,"The game was", 0);
        String restOfStatement = statement.substring(psn + 12).trim();
        System.out.println("Why did you think the game was " + restOfStatement + " ?");
        statement = input.nextLine();
        System.out.println("Okay, I'll keep that in mind. Thank you for playing!");

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
     * Arrays that contain the possible responses the user can get from correct choices, incorrect choices, a good score,
     * a neutral score, or a bad score.
     */
    private String [] randomCorrectResponse = {"That's correct!", "Nice one!", "You got it right!", "Great job!", "Superb!"};
    private String [] randomWrongResponse = {"Hmm...that doesn't seem right.", "That's incorrect.", "Nope, that's not it.", "Maybe you mixed that up with another word?", "That's incorrect. Did you make a typo?"};
    private String [] randomPositiveResponse = {"Awesome!", "Congratulations!", "You're a genius!"};
    private String [] randomNeutralResponse = {"That was okay.", "Keep studying harder!", "Make sure to review your material."};
    private String [] randomNegativeResponse = {"You can do better than that.", "You'll do better next time.", "Maybe you should reference your notes again."};

}
