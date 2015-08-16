/** The Class to define QuestionReaderException for the QuestionReader class.
 *
 * @author Gixbit */
@SuppressWarnings("serial")
public class QuestionReaderException extends Exception {
	/** Instantiates a new question reader exception. */
	public QuestionReaderException() {
	}
	
	/** Instantiates a new question reader exception.
	 *
	 * @param m
	 *            - The message to send to the console. */
	public QuestionReaderException(String m) {
		super(m);
	}
}
