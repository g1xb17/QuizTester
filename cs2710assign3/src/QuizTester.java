/** @author Gixbit The main class for doing quiz testing. */
public class QuizTester {
	/** @param args
	 *            - Command line args (Unused). */
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("Enter a file name to use as a quiz. Type 'Q' to quit.");
		String x = in.next();
		while (!x.equalsIgnoreCase("q")) {
			try {
				Quiz q = new Quiz(new java.io.File(x));
				q.startQuiz();
				System.out.println("Another file to use as a quiz? Otherwise Type 'Q' to quit.");
				x = in.next();
			} catch (QuestionReaderException e) {
				System.out.println(e.getMessage());
				System.out.println("Error occured, try another file to use as a quiz? Otherwise Type 'Q' to quit.");
				x = in.next();
			}
		}
		in.close();
	}
}
