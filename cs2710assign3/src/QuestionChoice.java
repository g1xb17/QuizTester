import java.util.ArrayList;

/** The Class QuestionChoice that dictates choice questions.
 *
 * @author Gixbit */
public class QuestionChoice extends QuestionSingle implements Question {
	/** The type of question. */
	private final String type = "Choice";
	
	/** Instantiates a new multiple choice question with multiple answers.
	 *
	 * @param question
	 *            - The question to be asked
	 * @param ans
	 *            - The answers list
	 * @param nans
	 *            - The wrong answers list */
	public QuestionChoice(String question, ArrayList<String> ans, ArrayList<String> nans) {
		super(question, ans, nans);
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
		return this.getClass().getName() + "[question=" + this.getQuestion() + ",ans=" + this.getAnswers() + ",nans=" + this.getWrongAnswers() + ",type=" + this.type
		+ ",choicesCount=" + this.getTotalChoices() + ",in=" + in + "]";
	}
}
