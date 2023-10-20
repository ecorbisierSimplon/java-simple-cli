import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class Cli {

	public static void main(String[] args) {
		String sep = System.lineSeparator();
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			// String command = scanner.nextLine(); // Get input from console as a string
			CommandLine commandLine = new CommandLine(scanner.nextLine());
			String command = commandLine.getCommand();
			String argument = commandLine.getArgument();
			Boolean hasArgument = commandLine.hasArgument();

			String output = "";

			// String[] commandArray = command.trim().split(" ", 2);
			// StringBuilder output = new StringBuilder();

			if (command.equals("exit") || command.equals("logout")) {
				break;

			} else if (command.equals("date")) {
				output = LocalDate.now().toString();// formattedDateNow); // Print the date

			} else if (command.equals("time")) {
				output = LocalDate.now().toString(); // Print the time

			} else if (command.equals("datetime")) {
				output = LocalDateTime.now().toString(); // Print the Date and Time

			} else if (command.equals("useraccount")) {
				output = System.getProperty("user.name"); // Print User name

			} else if (command.equals("userhome")) {
				output = System.getProperty("user.home"); // Print User Home

			} else if (command.equals("os")) {
				output = System.getProperty("os.name")
						+ " ("
						+ System.getProperty("os.version")
						+ ")";
				// Print os'information

			} else if (command.equals("printenv")) {
				// This command is used to reject printenv elements whose arguments are not
				// spaced between printenv and the 1st argument.
				if (hasArgument) { // Print value of environnement variable
					String test = System.getenv(argument);
					output = test == null ? "" : test; // if environnement variable is null
														// then transform output in argument empty
				} else { // if not arguments write
					StringBuilder outputBuild = new StringBuilder();
					for (String key : System.getenv().keySet()) { //
						outputBuild.append(key)
								.append("=")
								.append(System.getenv().get(key))
								.append(sep);
					}
					output = outputBuild.toString();
				}

			} else if (command.equals("echo") || command.equals("print")) {
				// This command is used to reject echo elements whose arguments are not spaced
				// between echo and the 1st argument.
				output = hasArgument ? argument : "";

			} else if (command.equals("ls")) {

				if (hasArgument) { // Save value of directory if argument existe
					File dossier = new File(argument);

					// le "fichier" existe et est un dossier
					if (dossier.exists() && dossier.isDirectory()) {// Verify if directory existe
						// listDirectory(output, argument); // Create list directory and file
						File dir = new File(argument);
						File[] liste = dir.listFiles();
						StringBuilder outputBuild = new StringBuilder();
						if (liste != null) {
							// Add directory and then files in StringBuilder
							for (File file : liste) {
								outputBuild.append(file.getName()).append(sep);
							}
							output = outputBuild.toString();
						}
					}
				}
				if (output.equals(""))
					output = "Not a directory !";

			} else {
				output = "Command '" + command + "' not found.";
			}

			System.out.println(output.toString()); // Print with new line (ln)

			System.out.print("> "); // Prompt
		}
		// Forces exit of the while loop
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");

	}

}
