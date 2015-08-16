import java.io.File;
import java.util.ArrayList;

/** The Class Quiz used for organizing questions to be asked in a quiz.
 * 
 * @author Gixbit */
public class Quiz {
	/** The questions in a quiz. */
	private ArrayList<Question> questions;
	/** The question reader that reads questions from the file. */
	private QuestionReader reader;
	/** The questions that were answered correctly so far in the quiz. */
	private int rightCount;
	/** The questions that were answered incorrectly so far. */
	private int wrongCount;
	
	/** Instantiates a new quiz to be used based on the file given
	 *
	 * @param file
	 *            - The file to be used for the quiz
	 * @throws QuestionReaderException
	 *             - This exception is thrown if the file is not the right format. */
	public Quiz(File file) throws QuestionReaderException {
		reader = new QuestionReader(file);
		this.questions = reader.readFile();
		this.rightCount = 0;
		this.wrongCount = 0;
	}
	
	/** Starts the quiz. */
	public void startQuiz() {
		for (int i = 0; i < questions.size(); i++) {
			boolean x = questions.get(i).askQuestion();
			if (x)
				rightCount++;
			else
				wrongCount++;
		}
		endQuiz();
	}
	
	/** Gets the number of questions.
	 *
	 * @return the number of questions */
	public int getNumberOfQuestions() {
		return questions.size();
	}
	
	/** Gets the amount of questions that were answered incorrectly
	 *
	 * @return the incorrectly answered count */
	public int getWrongCount() {
		return this.wrongCount;
	}
	
	/** Gets the amount of questions that were answered correctly.
	 *
	 * @return the right count */
	public int getRightCount() {
		return this.rightCount;
	}
	
	/** Ends the quiz and outputs some information regarding it. */
	public void endQuiz() {
		System.out.printf(	"You have finished the quiz.\nYou got %d out of %d right for a total score of %.0f%%!\n", this.rightCount, this.questions.size(),
							(((double)this.rightCount / this.questions.size()) * 100.0));
	}
	
	public void newQuiz(File file) {
		this.reader.setFile(file);
		try {
			this.questions = reader.readFile();
		} catch (QuestionReaderException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** String containing information about the object
	 * 
	 * @return String - Returns string representation of the object. */
	public String toString() {
		return this.getClass().getName() + "[questions=" + questions + ",reader=" + reader + ",rightCount=" + rightCount + ",wrongCount=" + wrongCount + "]";
	}
}
