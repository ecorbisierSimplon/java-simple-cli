import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else if (command.equals("date")) {
				output = dateNow("date");
			} else if (command.equals("time")) {
				output = dateNow("time");
			} else if (command.equals("datetime")) {
				output = dateNow("");
			} else if (command.equals("useraccount")) {
				output = sessionName("name");
			} else if (command.equals("userhome")) {
				output = sessionName("");
			} else {
				// String concatenation
				output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print(" > "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
	}

	public static String sessionName(String value) {
		if (value == "name") {
			return System.getProperty("user.name");
		}
		return System.getProperty("user.home");
	}

	public static String dateNow(String timeVal) {
		DateTimeFormatter formattedDateNow;
		switch (timeVal) {
			case "time":
				formattedDateNow = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSSS");
				break;
			case "date":
				formattedDateNow = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				break;
			default:
				formattedDateNow = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
				break;
		}

		LocalDateTime today = LocalDateTime.now(); // Add date today
		return today.format(formattedDateNow);
	}

}