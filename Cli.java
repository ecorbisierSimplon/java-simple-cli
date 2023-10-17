import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String[] commandArray = command.trim().split(" ", 2);
			String output = ""; // A variable named output of type String
			if (Arrays.asList("exit", "logout").contains(commandArray[0])) {
				break;
				
			} else if (commandArray[0].equals("date")) {
				LocalDate formattedDateNow = LocalDate.now();
				output = formattedDateNow.toString(); // Print the date

			} else if (commandArray[0].equals("time")) {
				LocalTime formattedTimeNow = LocalTime.now();
				output = formattedTimeNow.toString(); // Print the time

			} else if (commandArray[0].equals("datetime")) {
				LocalDateTime formattedDateTimeNow = LocalDateTime.now();
				output = formattedDateTimeNow.toString(); // Print the Date and Time

			} else if (commandArray[0].equals("useraccount")) {
				output = System.getProperty("user.name"); // Print User name

			} else if (commandArray[0].equals("userhome")) {
				output = System.getProperty("user.home"); // Print User Home

			} else if (commandArray[0].equals("os")) {
				output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
				// Print os'information

			} else if (commandArray[0].equals("printenv")) {
				// This command is used to reject printenv elements whose arguments are not
				// spaced between printenv and the 1st argument.
				if (commandArray.length > 1) { // Print value of environnement variable
					output = System.getenv(commandArray[1]);
					output = output == null ? "" : output; // if environnement variable is null then transform output in
															// argument empty
				} else {
					Map<String, String> varEnv = System.getenv();
					for( String key : varEnv.keySet() ) {
						output += key + "=" + varEnv.get( key ).toString() + "\n";
					}
				}

			} else if (Arrays.asList("echo", "print").contains(commandArray[0])) {
				// This command is used to reject echo elements whose arguments are not spaced
				// between echo and the 1st argument.
				output = commandArray.length > 1 ? commandArray[1] : "";

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