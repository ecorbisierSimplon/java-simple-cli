import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Commands {

	public static String date(CommandLine commandLine) {
		return LocalDate.now().toString(); // Print the date
	}

	public static String time(CommandLine commandLine) {
		return LocalDate.now().toString(); // Print the time
	}

	public static String datetime(CommandLine commandLine) {
		return LocalDateTime.now().toString(); // Print the Date and Time
	}

	public static String useraccount(CommandLine commandLine) {
		return System.getProperty("user.name"); // Print User name
	}

	public static String userhome(CommandLine commandLine) {
		return System.getProperty("user.home"); // Print User Home
	}

	public static String os(CommandLine commandLine) {
		String name = System.getProperty("os.name");
		String version = System.getProperty("os.version");
		return name + " (" + version + ")";
		// Print os'information
	}

	public static String printenv(CommandLine commandLine) {
		// This command is used to reject printenv elements whose arguments are not
		// spaced between printenv and the 1st argument.
		if (commandLine.hasArgument()) { // Print value of environnement variable
			String test = System.getenv(commandLine.getArgument());
			return test == null ? "" : test; // if environnement variable is null
												// then transform output in argument empty
		} else { // if not arguments write
			StringBuilder outputBuild = new StringBuilder();
			for (String key : System.getenv().keySet()) { //
				outputBuild.append(key)
						.append("=")
						.append(System.getenv().get(key))
						.append(System.lineSeparator());
			}
			return outputBuild.toString();
		}
	}

	public static String echo(CommandLine commandLine) {
		// This command is used to reject echo elements whose arguments are not spaced
		// between echo and the 1st argument.
		return commandLine.hasArgument() ? commandLine.getArgument() : "";
	}

	public static String print(CommandLine commandLine) {
		return commandLine.hasArgument() ? commandLine.getArgument() : "";
	}

	public static String ls(CommandLine commandLine) {

		if (commandLine.hasArgument()) { // Save value of directory if argument existe
			File dossier = new File(commandLine.getArgument());

			// le "fichier" existe et est un dossier
			if (dossier.exists() && dossier.isDirectory()) {// Verify if directory existe
				// listDirectory(output, argument); // Create list directory and file
				File dir = new File(commandLine.getArgument());
				File[] liste = dir.listFiles();
				StringBuilder outputBuild = new StringBuilder();
				if (liste != null) {
					// Add directory and then files in StringBuilder
					for (File file : liste) {
						outputBuild.append(file.getName()).append(System.lineSeparator());
					}
					return outputBuild.toString();
				}
			}
		}
		// if (output.equals(""))
		return "Not a directory !";
	}

}
