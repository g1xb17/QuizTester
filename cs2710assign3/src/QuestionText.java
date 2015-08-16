import java.util.ArrayList;

/** The Class QuestionText that dictates the text answer questions.
 *
 * @author Gixbit */
public class QuestionText extends QuestionBase implements Question {
	/** The type of question. */
	private final String type = "Text";
	
	/** Instantiates a new Text Question.
	 *
	 * @param question
	 *            - The question
	 * @param ans
	 *            - The answers application to the question */
	public QuestionText(String question, ArrayList<String> ans) {
		super(question, ans);
	}
	
	/** Gets the question specifically to be asked of the user.
	 * 
	 * @return String - String containing the question. */
	@Override
	public boolean askQuestion() {
		in = new java.util.Scanner(System.in);
		System.out.println(getQuestion() + "\nWhat is the answer?");
		String x = in.nextLine();
		return checkAnswer(x);
	}
	
	/** Gets the type of question this object represents.
	 *
	 * @return the type */
	public String getType() {
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
