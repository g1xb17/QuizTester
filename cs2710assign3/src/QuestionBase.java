import java.util.ArrayList;
import java.util.Scanner;

/** The Class QuestionBase that dictates the basic question that can be extended by other questions.
 *
 * @author Gixbit */
@SuppressWarnings("unchecked")
public class QuestionBase implements Question {
	/** The question that is asked to the user. */
	private String question;
	/** The answers that are applicable to the question. */
	private ArrayList<String> ans;
	/** The incorrect answers used in the question if applicable. */
	private ArrayList<String> nans;
	/** The type of question. */
	private final String type = "Basic";
	/** The scanner used in all questions. */
	public static Scanner in;
	
	/** Instantiates a new basic question
	 *
	 * @param question
	 *            - The question to be asked to the user
	 * @param ans
	 *            - The list of answers.
	 * @param nans
	 *            - The list of incorrect answers to ask with the right answers. Not applicable in
	 *            Basic questions. */
	public QuestionBase(String question, ArrayList<String> ans, ArrayList<String> nans) {
		this.question = question;
		this.ans = new ArrayList<String>();
		this.ans.addAll(ans);
		this.nans = new ArrayList<String>();
		this.nans.addAll(nans);
	}
	
	/** Instantiates a new basic question containing only the question and the list of answers.
	 *
	 * @param question
	 *            - The question to be asked to the user
	 * @param ans
	 *            - The list of answers. */
	public QuestionBase(String question, ArrayList<String> ans) {
		this.question = question;
		this.ans = new ArrayList<String>();
		this.ans.addAll(ans);
		this.nans = null;
	}
	
	/** Instantiates a new basic question containing only the question.
	 *
	 * @param question
	 *            - The question to be asked to the user */
	public QuestionBase(String question) {
		this.question = question;
		this.nans = null;
		this.ans = null;
	}
	
	/** Method used for asking a question to the user and returning a boolean to check and add to the
	 * score of the test.
	 * 
	 * @return Boolean - True if question is answered correctly. */
	@Override
	public boolean askQuestion() {
		in = new Scanner(System.in);
		System.out.println(getQuestion() + "\nWhat is the answer?");
		String x = in.nextLine().trim().toLowerCase();
		return checkAnswer(x);
	}
	
	/** Gets the question specifically to be asked of the user.
	 * 
	 * @return String - String containing the question. */
	@Override
	public String getQuestion() {
		return this.question;
	}
	
	/** Sets the question to be asked.
	 *
	 * @param question
	 *            the new question */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/** Check answer from the list of answers.
	 *
	 * @param answer
	 *            - The answer
	 * @return true, if correct; false, if incorrect. */
	public boolean checkAnswer(String answer) {
		if (getAnswers().contains(answer))
			return true;
		else
			return false;
	}
	
	/** Method for returning the list of acceptable answers for the question.
	 * 
	 * @return ArrayList<String> - Returns arrayList of answers. */
	@Override
	public ArrayList<String> getAnswers() {
		return (ArrayList<String>)this.ans.clone();
	}
	
	/** Gets the list of wrong answers.
	 *
	 * @return the wrong answers list */
	public ArrayList<String> getWrongAnswers() {
		return (ArrayList<String>)this.nans.clone();
	}
	
	/** Sets the list of right answers.
	 *
	 * @param ans
	 *            the new answer array */
	public void setAnswerArray(ArrayList<String> ans) {
		this.ans = (ArrayList<String>)ans.clone();
	}
	
	/** Sets the list of wrong answers.
	 *
	 * @param nans
	 *            the new wrong answer array */
	public void setWrongAnswerArray(ArrayList<String> nans) {
		this.nans = (ArrayList<String>)nans.clone();
	}
	
	/** Random number generator with min and max value.
	 *
	 * @param min
	 *            - The min value
	 * @param max
	 *            - The max value
	 * @return the randomized integer */
	public static int random(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1) + min);
	}
	
	/** Random number generator with only a max value, min is set to 0;
	 *
	 * @param max
	 *            - The max
	 * @return the randomized integer */
	public static int random(int max) {
		return random(0, max);
	}
	
	/** Gets a double value with the scanner. For use in questions that have a number.
	 * 
	 * @return the double entered */
	public static double getDouble() {
		in = new Scanner(System.in);
		double x = 0;
		while (true) {
			try {
				x = in.nextDouble();
				return x;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input: Enter a double only");
				in.next();
			}
		}
	}
	
	/** Gets an integer value with the scanner.
	 *
	 * @param max
	 *            - The maximum value present, minimum is always 1.
	 * @return the integer entered */
	public int getInt(int max) {
		in = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		int x = 0;
		while (true) {
			try {
				x = in.nextInt();
				if (!(x >= 1 && x <= max)) {
					throw new java.lang.ArrayIndexOutOfBoundsException();
				}
				return x;
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid input: Outside of the choices possible");
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input: Enter an integer only");
				in.next();
			}
		}
	}
	
	/** Gets the question type.
	 *
	 * @return the question type */
	public String getQuestionType() {
		return type;
	}
	
	/** String containing information about the object
	 * 
	 * @return String - Returns string representation of the object. */
	@Override
	public String toString() {
		return this.getClass().getName() + "[question=" + question + ",ans=" + ans + ",nans=" + nans + ",type=" + type + ",in=" + in + "]";
	}
}
