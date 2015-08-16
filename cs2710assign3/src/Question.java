/** Interface for asking any question of any type
 * 
 * @author Gixbit */
public interface Question {
	/** Method used for asking a question to the user and returning a boolean to check and add to the
	 * score of the test.
	 * 
	 * @return Boolean - True if question is answered correctly. */
	public boolean askQuestion();
	
	/** Gets the question specifically to be asked of the user.
	 * 
	 * @return String - String containing the question. */
	public String getQuestion();
	
	/** Method for returning the list of acceptable answers for the question.
	 * 
	 * @return ArrayList<String> - Returns arrayList of answers. */
	public java.util.ArrayList<String> getAnswers();
}
