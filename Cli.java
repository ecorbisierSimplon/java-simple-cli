import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String[] commandArray = command.trim().split(" ", 2);
			String output = ""; // A variable named output of type String
			if (commandArray[0].equals("exit") || commandArray[0].equals("logout")) {
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
					output = output == null ? "" : output; // if environnement variable is null
															// then transform output in argument empty
				} else { // if not arguments write
					Map<String, String> varEnv = System.getenv(); // Transforms a string into an array
																	// with a key and a value linked to the key.
					for (String key : varEnv.keySet()) { //
						output += key + "=" + varEnv.get(key) + System.lineSeparator();
					}
				}

			} else if (commandArray[0].equals("echo") || commandArray[0].equals("print")) {
				// This command is used to reject echo elements whose arguments are not spaced
				// between echo and the 1st argument.
				output = commandArray.length > 1 ? commandArray[1] : "";

			} else if (commandArray[0].equals("ls")) {

				if (commandArray.length > 1) { // Save value of directory if argument existe
					String argument = ""; // Save value default if directory empty
					argument = commandArray[1];
					File dossier = new File(argument);
					// le "fichier" existe et est un dossier
					if (dossier.exists() && dossier.isDirectory()) { // Verify if directory existe
						output = listDirectory(argument); // Create list directory and file

					}					
										
				}
				if (output.equals(""))
							output = "Not a directory !";	

			} else {
				output = commandArray[0].equals("") ? "Please enter your comand !"
						: "Command '" + commandArray[0] + "' not found.";
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

	public static String listDirectory(String directory) { // list directory and file
		String separator = System.lineSeparator();
		File dir = new File(directory);
		File[] liste = dir.listFiles();

		if (liste != null) {
			/*
			 * sorts the list alphabetically, case insensitive, with the directory first and
			 * then the files as part 2
			 */
			Arrays.sort(liste, Comparator.comparing(File::isDirectory).reversed()
					.thenComparing((file1, file2) -> file1.getName().compareToIgnoreCase(file2.getName())));

			// create a StringBuilder to store sorted files
			StringBuilder result = new StringBuilder();

			// Add directory and then files in StringBuilder
			for (File file : liste) {
				result.append(file.getName()).append(separator);
			}
			return String.join("", result);
		}

		return "";

	}

}