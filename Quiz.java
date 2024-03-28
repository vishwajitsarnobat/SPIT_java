import java.util.Random;
import java.util.ArrayList;

abstract class QuestionText {
	String question_text;
	abstract void getSolution();
	abstract void verifyanswer(int enteredans);

	QuestionText(String question_text) {
		this.question_text = question_text;
	}
}

class TrueFalse extends QuestionText {
	int mySolution;
	String ansText;

	TrueFalse(String question_text, int mySolution) {
		super(question_text);
		this.mySolution = mySolution;

		if (mySolution == 0) {
			ansText = "True";
		}
		else {
			ansText = "False";
		}
	}

	void getQuestion() {
		System.out.println("The question is: " + question_text); 
	}
	
	void getSolution() {
		System.out.println("The correct answer to this question is: " + ansText);
	}

	void verifyanswer(int enteredans) {
		if (enteredans == mySolution) {
			System.out.println(ansText + "is the right answer");
		} 
		else {
			System.out.println(ansText + "is the not the right answer");
		}
	}
}

class MCQ extends QuestionText{
	int mySolution;
	String ansText;

	MCQ(String question_text, int mySolution) {
		super(question_text);
		this.mySolution = mySolution;
	}

	void getQuestion() {
		System.out.println("The question is: " + question_text); 
	}
	
	void getSolution() {
		System.out.println("The correct option is: " + ansText);
	}

	void verifyanswer(int enteredans) {
		if (enteredans == mySolution) {
			System.out.println(ansText + "is the right option");
		} 
		else {
			System.out.println(ansText + "is the not the right option");
		}
	}
}

class Quiz {
	public static void main(String[] args) {
		ArrayList<QuestionText> quesArr = new ArrayList<>();

		quesArr.add(new TrueFalse("Delhi is the capital of India.", 0));
		quesArr.add(new TrueFalse("The answer to this question is false.", 1));
		quesArr.add(new TrueFalse("India is a democratic country (democracy means where leader is chosen by the people by conducting free and fair elections)", 0));
		quesArr.add(new TrueFalse("There is a set of all sets.", 0));
		quesArr.add(new MCQ("What is the latest version of JDK? \n 1. 18 \n 2. 19 \n 3. 21 \n 4. 22", 4));
		quesArr.add(new MCQ("What is the best way to get an idea of stats data? \n 1. Mean \n 2. Median \n 3. Variance \n 4. Mode", 3));
		quesArr.add(new MCQ("Will AI like Devin kill Web-Dev? \n 1. Yes, I agree. \n 2. No, I disagree. \n 3. Yes for frontend, backend stands a chance. \n 4. Yes for backend, frontend stands a chance.", 4));
		
		Random rand = new Random();
		ArrayList<QuestionText> newQuesArr = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			int temp = rand.nextInt(7 - i);
			newQuesArr.add(quesArr.get(temp));
			quesArr.remove(temp);
		}
	}
}
