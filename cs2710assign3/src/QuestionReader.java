import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/** The Class QuestionReader.
 *
 * @author Gixbit */
@SuppressWarnings("unchecked")
public class QuestionReader {
	/** The questions array. */
	private ArrayList<Question> questionMaker;
	/** The file to be used in the scanner. */
	private File file;
	/** The scanner the reads the file. */
	private Scanner readFile;
	
	/** Instantiates a new question reader that reads a file and organizes question objects.
	 *
	 * @param file
	 *            - The file to be used for questions
	 * @throws QuestionReaderException
	 *             the question reader exception */
	public QuestionReader(File file) throws QuestionReaderException {
		this.file = file;
		if (!file.exists() || file == null) {
			throw new QuestionReaderException("File does not exist or not found!");
		}
		try {
			readFile = new Scanner(file);
			questionMaker = new ArrayList<Question>();
		} catch (java.io.FileNotFoundException e) {
			System.out.println("File Not Found Exception!");
		}
	}
	
	/** Gets a copy of the question array.
	 *
	 * @return the questions array */
	public ArrayList<Question> getQuestionsArray() {
		return (ArrayList<Question>)this.questionMaker.clone();
	}
	
	/** Sets the file to be used in the question maker
	 *
	 * @param file
	 *            - the new file */
	public void setFile(File file) {
		this.file = file;
	}
	
	/** Gets the file currently used in the question maker.
	 *
	 * @return the file used in the question maker */
	public File getFile() {
		return this.file;
	}
	
	/** Reads the file and creates an array list containing questions of the interface Question.
	 *
	 * @return the array list created of questions
	 * @throws QuestionReaderException
	 *             throws an exception if anything is found wrong in the file */
	public ArrayList<Question> readFile() throws QuestionReaderException {
		ArrayList<String> questionLetter = new ArrayList<String>();
		questionLetter.add("T");
		questionLetter.add("S");
		questionLetter.add("C");
		questionLetter.add("N");
		// E stands for End of file, but is not explicitly included in the file,
		// but, it is optional.
		questionLetter.add("E");
		if (!readFile.hasNextLine()) {
			throw new QuestionReaderException("File is empty!");
		}
		String x = readFile.nextLine();
		ArrayList<String> answersToAdd = new ArrayList<String>();
		ArrayList<String> badAnswersToAdd = new ArrayList<String>();
		while (readFile.hasNextLine()) {
			// Text Question Formatter
			if (x.equalsIgnoreCase("T")) {
				x = readFile.nextLine();
				String question = x;
				x = readFile.nextLine();
				while (!questionLetter.contains(x)) {
					if (x.length() > 0) {
						answersToAdd.add(x);
					}
					try {
						x = readFile.nextLine().trim();
					} catch (java.util.NoSuchElementException e) {
						x = "E";
					}
				}
				if (answersToAdd.size() > 0) {
					questionMaker.add(new QuestionText(question, answersToAdd));
				} else {
					throw new QuestionReaderException("Illegal Text Question! Missing an Answer");
				}
				answersToAdd.clear();
			}
			// Single Choice Question Formatter
			else if (x.equalsIgnoreCase("S")) {
				x = readFile.nextLine().trim();
				String question = x;
				x = readFile.nextLine();
				while (!questionLetter.contains(x)) {
					if (x.length() > 0) {
						if (x.charAt(0) == '+') {
							x = x.substring(1).trim();
							answersToAdd.add(x);
						} else if (x.charAt(0) == '-') {
							x = x.substring(1).trim();
							badAnswersToAdd.add(x);
						} else {
							throw new QuestionReaderException("Illegal Single Choice Question Format!");
						}
					}
					try {
						x = readFile.nextLine().trim();
					} catch (java.util.NoSuchElementException e) {
						x = "E";
					}
				}
				if (answersToAdd.size() > 0) {
					questionMaker.add(new QuestionSingle(question, answersToAdd, badAnswersToAdd));
				} else {
					throw new QuestionReaderException("Illegal Single Choice Question! Missing an Answer");
				}
				answersToAdd.clear();
				badAnswersToAdd.clear();
			}
			// Choice Question Formatter
			else if (x.equalsIgnoreCase("C")) {
				x = readFile.nextLine().trim();
				String question = x;
				x = readFile.nextLine();
				while (!questionLetter.contains(x)) {
					if (x.length() > 0) {
						if (x.charAt(0) == '+') {
							x = x.substring(1).trim();
							answersToAdd.add(x);
						} else if (x.charAt(0) == '-') {
							x = x.substring(1).trim();
							badAnswersToAdd.add(x);
						} else {
							throw new QuestionReaderException("Illegal Multiple Choices Question Format!");
						}
					}
					try {
						x = readFile.nextLine().trim();
					} catch (java.util.NoSuchElementException e) {
						x = "E";
					}
				}
				if (answersToAdd.size() > 0) {
					questionMaker.add(new QuestionChoice(question, answersToAdd, badAnswersToAdd));
				} else {
					throw new QuestionReaderException("Illegal Multiple Choices Question! Missing an Answer");
				}
				answersToAdd.clear();
				badAnswersToAdd.clear();
			}
			// Number answers formatter
			else if (x.equalsIgnoreCase("N")) {
				x = readFile.nextLine().trim();
				String question = x;
				x = readFile.nextLine().trim();
				while (!questionLetter.contains(x)) {
					try {
						try {
							if (x.length() > 0) {
								Double.parseDouble(x);
								answersToAdd.add(x);
							}
						} catch (NumberFormatException e) {
							throw new QuestionReaderException("Illegal Number Question Format!");
						}
						x = readFile.nextLine().trim();
					} catch (java.util.NoSuchElementException e) {
						x = "E";
					}
				}
				if (answersToAdd.size() > 0) {
					questionMaker.add(new QuestionNumber(question, answersToAdd));
				} else {
					throw new QuestionReaderException("Illegal Number Question! Missing an Answer");
				}
				answersToAdd.clear();
			} else if (x.length() == 0) {
				x = readFile.nextLine().trim();
			} else {
				throw new QuestionReaderException("Illegal File Format!");
			}
		}
		return this.getQuestionsArray();
	}
	
	/** String containing information about the object
	 * 
	 * @return String - Returns string representation of the object. */
	@Override
	public String toString() {
		return this.getClass().getName() + "[file=" + this.file + ",questionMaker=" + this.questionMaker + ",readFile=" + this.readFile + "]";
	}
}
