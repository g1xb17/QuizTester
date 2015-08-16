import java.util.ArrayList;

/** The Class QuestionNumber that dictates number questions.
 *
 * @author Gixbit */
public class QuestionNumber extends QuestionBase implements Question {
	/** The type of question. */
	private final String type = "Number";
	
	/** Instantiates a new number answer question.
	 *
	 * @param question
	 *            - The question to be asked
	 * @param ans
	 *            - The list of answers (containing numbers) */
	public QuestionNumber(String question, ArrayList<String> ans) {
		super(question, ans);
	}
	
	/** Method used for asking a question to the user and returning a boolean to check and add to the
	 * score of the test.
	 * 
	 * @return Boolean - True if question is answered correctly. */
	@Override
	public boolean askQuestion() {
		in = new java.util.Scanner(System.in);
		System.out.println(getQuestion() + "\nWhat is the answer?");
		String x = Double.toString(getDouble());
		return checkAnswer(x);
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
	public String toString() {
		return this.getClass().getName() + "[question=" + this.getQuestion() + ",ans=" + this.getAnswers() + ",nans=" + this.getWrongAnswers() + ",type=" + this.type + ",in="
		+ in + "]";
	}
}
