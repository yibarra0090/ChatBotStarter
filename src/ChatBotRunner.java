import java.util.Scanner;
/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{
	public static void main(String[] args)
	{
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();
		ChatBot4 chatbot4 = new ChatBot4();
		Scanner in = new Scanner (System.in);
        System.out.println("Welcome to the chatbot, nice to meet you.");
        System.out.println("Please type 1 to play WordLibs");
        System.out.println("Please type 2 to play Hangman");
        System.out.println("Please type 3 to speak to our Joke/RiddleBot.");
        System.out.println("Please type 4 to speak to our QuizBot.");
        System.out.println("Say 'bye' if you no longer want to play any of the WordBots.");
		String statement = in.nextLine();
		while (!statement.equals("Bye"))
		{
			if (statement.equals("1")){
				chatbot1.chatLoop(statement);
			}
			if (statement.equals("2")){
				chatbot2.chatLoop(statement);
			}
			if (statement.equals("3")) {
				chatbot3.chatLoop(statement);
			}
			if (statement.equals("4")) {
				chatbot4.chatLoop(statement);
			}
            System.out.println("Please type 1 to play WordLibs");
            System.out.println("Please type 2 to play Hangman");
            System.out.println("Please type 3 to speak to our Joke/RiddleBot.");
            System.out.println("Please type 4 to speak to our QuizBot.");
			statement = in.nextLine();
		}
	}
}
