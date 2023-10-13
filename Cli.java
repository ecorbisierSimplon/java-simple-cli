import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		DateTimeFormatter formattedDateNow = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime today = LocalDateTime.now(); // Add date today
		String dateNow = today.format(formattedDateNow);

		System.out.print(dateNow + " > "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else {
				// String concatenation
				output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print(dateNow + " > "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
	}

}