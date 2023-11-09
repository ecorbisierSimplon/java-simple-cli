import java.util.Scanner;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			// String command = scanner.nextLine(); // Get input from console as a string
			CommandLine commandLine = new CommandLine(scanner.nextLine());

			String command = commandLine.getCommand();

			String output = "";

			if (command.equals("exit") || command.equals("logout")) {
				break;

			} else if (command.equals("date")) {
				output = Commands.date(commandLine);
			} else if (command.equals("time")) {
				output = Commands.time(commandLine);
			} else if (command.equals("datetime")) {
				output = Commands.datetime(commandLine);
			} else if (command.equals("useraccount")) {
				output = Commands.useraccount(commandLine);
			} else if (command.equals("userhome")) {
				output = Commands.userhome(commandLine);
			} else if (command.equals("os")) {
				output = Commands.os(commandLine);
			} else if (command.equals("printenv")) {
				output = Commands.printenv(commandLine);
			} else if (command.equals("echo") || command.equals("print")) {
				output = Commands.echo(commandLine);
			} else if (command.equals("ls")) {
				output = Commands.ls(commandLine);
			} else if (command.equals("cat")) {
				output = Commands.cat(commandLine);
			} else if (command.equals("help")) {
				output = Commands.help(commandLine);
			} else {
				output = "Command '" + command + "' not found.";
			}

			System.out.println(output); // Print with new line (ln)

			System.out.print("> "); // Prompt
		}
		// Forces exit of the while loop
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");

	}

}
