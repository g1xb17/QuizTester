import java.util.ArrayList;

/** The Class QuestionSingle that dictates the single choice questions.
 *
 * @author Gixbit */
@SuppressWarnings("unchecked")
public class QuestionSingle extends QuestionBase implements Question {
	/** The type of question. */
	private final String type = "Single";
	/** The number of choices present. */
	private int choicesCount;
	
	/** Instantiates a new question single.
	 *
	 * @param question
	 *            - The question
	 * @param ans
	 *            - The ans
	 * @param nans
	 *            - The nans */
	public QuestionSingle(String question, ArrayList<String> ans, ArrayList<String> nans) {
		super(question, ans, nans);
		this.choicesCount = ans.size() + nans.size();
	}
	
	/** Method used for asking a question to the user and returning a boolean to check and add to the
	 * score of the test.
	 * 
	 * @return Boolean - True if question is answered correctly. */
	@Override
	public boolean askQuestion() {
		System.out.println(getQuestion() + "\nHere are the choices:");
		ArrayList<String> randomList = randomList();
		for (int i = 0; i < this.choicesCount; i++) {
			System.out.printf("[%d]: %s\n", i + 1, randomList.get(i));
		}
		System.out.println("Select the [Number] for your answer...");
		String ans = randomList.get(getInt(randomList.size()) - 1);
		return checkAnswer(ans);
	}
	
	/** Returns a randomized question list of all the answers and wrong answers given.
	 *
	 * @return the array list containing all the choices */
	private ArrayList<String> randomList() {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(getAnswers());
		list.addAll(getWrongAnswers());
		ArrayList<String> mixed = new ArrayList<String>();
		while (list.size() != 0) {
			mixed.add(list.remove(random(list.size() - 1)));
		}
		return (ArrayList<String>)mixed.clone();
	}
	
	/** Gets the type of question this object represents.
	 *
	 * @return the type */
	public String getQuestionType() {
		return type;
	}
	
	/** Gets the total choices.
	 *
	 * @return the total choices */
	public int getTotalChoices() {
		return choicesCount;
	}
}
