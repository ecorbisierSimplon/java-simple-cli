import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			if (command.trim().equals("exit")) {
				break;

			} else if (command.trim().equals("date")) {
				LocalDate formattedDateNow = LocalDate.now();
				output = formattedDateNow.toString(); // Print the date

			} else if (command.trim().equals("time")) {
				LocalTime formattedTimeNow = LocalTime.now();
				output = formattedTimeNow.toString(); // Print the time

			} else if (command.trim().equals("datetime")) {
				LocalDateTime formattedDateTimeNow = LocalDateTime.now();
				output = formattedDateTimeNow.toString(); // Print the Date and Time

			} else if (command.trim().equals("useraccount")) {
				output = System.getProperty("user.name"); // Print User name

			} else if (command.trim().equals("userhome")) {
				output = System.getProperty("user.home"); // Print User Home

			} else if (command.trim().equals("os")) {
				output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
				// Print os'information

			} else if (command.startsWith("printenv ") || command.equals("printenv")) {
				// This command is used to reject printenv elements whose arguments are not
				// spaced between printenv and the 1st argument.

				if (!command.trim().equals("printenv")) { // Print value of environnement variable
					String[] argumentArray = command.split(" ");
					output = System.getenv(argumentArray[1]);
				}
				if (output == null) {
					output = ""; // if environnement variable is null then transform output in argument empty
				}

			} else if (command.startsWith("echo ") || command.equals("echo")) {
				// This command is used to reject echo elements whose arguments are not spaced
				// between echo and the 1st argument.
				output = !command.trim().equals("echo") ? command.substring("echo ".length()).trim() : "";

			} else {
				output = "Command '" + command + "' not found.";
			}

			System.out.println(output); // Print with new line (ln)
			if (output != "") // If output is not empty
				System.out.println(); // Adds a blank line for better readability

			System.out.print("> "); // Prompt
		}
		// Forces exit of the while loop
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");

	}

	public static String sessionName(String value) {
		if (value == "name") {
			return System.getProperty("user.name");
		}
		return System.getProperty("user.home");
	}

}