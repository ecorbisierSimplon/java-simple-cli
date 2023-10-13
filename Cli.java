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
			switch (command) {
				case "exit":
					// Forces exit of the while loop
					scanner.close(); // Best practice, always close a stream when no more needed
					System.out.println("Bye !");
					return;
				case "date":
					LocalDate formattedDateNow = LocalDate.now();
					System.out.println(formattedDateNow); // Print with new line (ln)
					break;
				case "time":
					LocalTime formattedTimeNow = LocalTime.now();
					System.out.println(formattedTimeNow); // Print with new line (ln)
					break;
				case "datetime":
					LocalDateTime formattedDateTimeNow = LocalDateTime.now();
					System.out.println(formattedDateTimeNow); // Print with new line (ln)
					break;
				case "useraccount":
					output = System.getProperty("user.name");
					break;
				case "userhome":
					output = System.getProperty("user.home");
					break;
				default:
					output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print(" > "); // Prompt
		}

	}

	public static String sessionName(String value) {
		if (value == "name") {
			return System.getProperty("user.name");
		}
		return System.getProperty("user.home");
	}

}