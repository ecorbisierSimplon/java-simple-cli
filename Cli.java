import java.util.Scanner;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			// String command = scanner.nextLine(); // Get input from console as a string
			CommandLine commandLine = new CommandLine(scanner.nextLine());
			Commands commands = new Commands();
			String command = commandLine.getCommand();
			// Commands commands = new Commands();

			// ******* CES ELEMENT SERONT UTILISER DANS Commands
			// String argument = commandLine.getArgument();
			// Boolean hasArgument = commandLine.hasArgument();

			String output = "";

			if (command.equals("exit") || command.equals("logout")) {
				break;

			} else if (command.equals("date")) {
				output = commands.date(commandLine);
			} else if (command.equals("time")) {
				output = commands.time(commandLine);
			} else if (command.equals("datetime")) {
				output = commands.datetime(commandLine);
			} else if (command.equals("useraccount")) {
				output = commands.useraccount(commandLine);
			} else if (command.equals("userhome")) {
				output = commands.userhome(commandLine);
			} else if (command.equals("os")) {
				output = commands.os(commandLine);
			} else if (command.equals("printenv")) {
				output = commands.printenv(commandLine);
			} else if (command.equals("echo")) {
				output = commands.echo(commandLine);
			} else if (command.equals("print")) {
				output = commands.print(commandLine);
			} else if (command.equals("ls")) {
				output = commands.ls(commandLine);
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
