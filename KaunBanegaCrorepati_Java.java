/*
	
	Object Oriented Programming 

	Kaun Banega Crorepati is a popular reality show on television.
	The host asks questions and the participant answers them to win prize money.
	It has 15 levels with the following price money at each level.

	Level 1: Rs. 1,000
	Level 2: Rs. 2,000
	Level 3: Rs. 3,000
	Level 4: Rs. 5,000
	Level 5: Rs. 10,000

	Level 6: Rs. 20,000
	Level 7: Rs. 40,000
	Level 8: Rs. 80,000
	Level 9: Rs. 1,60,000
	Level 10: Rs. 3,20,000
	
	Level 11: Rs. 6,40,000
	Level 12: Rs. 12,50,000
	Level 13: Rs. 25,00,000
	Level 14: Rs. 50,00,000
	Level 15: Rs. 100,00,000

	A player is out if he answers the question incorrectly.
	If a player is out after level 5 he/she gets Rs. 10,000 and after level 10 Rs. 3,20,000.

	If a player decides to quit then he/she gets the amount won at the previous level.
	For example, the participant quits at level 7 without giving a correct or wrong answer
	then the prize money for level 6 which is Rs. 20,000 is awarded.

	The test for you is to write a Java program using the OOP principles to simulate this game.
	Your answer to this programming test will be Autograded.
	So, you have to write your program by STRICTLY following the specifications given below.

	A Java interface named Quiz with 6 methods is provided. Don't change this interface.
	Write a Java class KaunBanegaCrorepati that implements the given Quiz interface.
	The autograder creates an object of KaunBanegaCrorepati to test your program.

	KaunBanegaCrorepati must implement the following:
		1. Create questions that should be shown to the participant.
			* Implement and use quiz interface method addQuestion
		
		2. Keyboard input for participant name, age and phone.
			* Implement and use quiz interface method registerParticipant
		
		3. Display questions in the order of level 1 to 15
			* Implement and use quiz interface method getNextQuestion
		
		4. For each question the participant enters one of the 4 options A, B, C or D
		
		5. Participant may also enters "quit" if he/she chooses to exit with current prize money
		
		6. If the participant dosen't quit then, lock the answer
			* Implement and use quiz interface method lockAnswer
		
		7. If answer is right then go to 2, otherwise quit with the prize money
		
		8. If the participant completes all 15 questions then he wins 1 crore

		9. Test your program to check if all the methods are working as specified by writing a main method.

	Implement the following classes as specified.

	Participant class with name, age, phone, currentLevel and prizeMoney as private instance variables.
	Provide the following methods in the Participant class.
		public String getName() - returns the name of the participant
		public int getAge() - returns the age of the participant
		public String getPhone() - returns the phone of the participant

	Question class with question, level and correctAnswer as protected instance variables.
	Provide the following methods in the Question class.
		public String getQuestion() - returns the question text
		public int getLevel() - returns the question level which is from 1 to 15
		public String getCorrectAnswer() - returns the correct answer to this question

	VERY IMPORTANT: None of the Quiz interface methods should have console input or output.
	Otherwise the autograder fails there is no way to evaluate your submission.

	All the best!
*/

interface Quiz{
	
	// addQuestion adds the question given in the parameter and adds it to the questions array
	void addQuestion(Question q);

	// The quiz begins with the registration of the participant
	// Participant name, age in years, phone number and friend's phone number are the parameters
	// an instance of the participant should be created and returned
	Participant registerParticipant(String name, int age, String phone);

	// getCurrentLevel returns the current level the participant is playing
	// It should return a value between 1 - 15 inclusive
	int getCurrentLevel();

	// getNextQuestion returns the next question for the participant to answer
	// The question object has the question text along with options A B C and D
	Question getNextQuestion();

	// lockAnswer accepts the question object and the participants answer
	// Checks if the answer is correct and returns true.
	// If the answer is incorrect it returns false.
	// It also updates the participant's
	boolean lockAnswer(Question q, String answer);

	// getPrizeMoney returns the current prize money the participant is awarded
	// For example, if he/she answered level 6 then Rs. 20,000 is the prize money.
	int getPrizeMoney();

}

public class KaunBanegaCrorepati implements Quiz{

	public static void main(String[] args){

		Quiz kbc = new KaunBanegaCrorepati();

		for(int i = 0; i < 15; i++)
			// create an object of question with 3 parameters
			// question text that is displayed to the user
			// question level which is from 1 to 15
			// correct answer to the question
			// the question data can be from a keyboard, file or even hard coded like below
			kbc.addQuestion(new Question("Question text", i, "A"));

		// register the participant
		Participant p = kbc.registerParticipant("Praveen", 30, "9989968765");

		// get the first question
		Question question = kbc.getNextQuestion();
		while(question != null){
			// display the question to the user
			// there can be multiple ways of displaying the question
			// you can do it anyway you want
			System.out.println(question);

			// take input from the user
			Scanner s = new Scanner(System.in);
			String input = s.next();
			if(!input.equals("quit")){
				if(kbc.lockAnswer(question, input)){
					question = kbc.getNextQuestion();
				}else{
					question = null;
				}
			}
		}


	}

}
