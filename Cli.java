import java.util.Scanner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cli {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)

		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			// String command = scanner.nextLine(); // Get input from console as a string
			CommandLine commandLine = new CommandLine(scanner.nextLine());
			String command = commandLine.getCommand();
			// Commands commands = new Commands();

			// ******* CES ELEMENT SERONT UTILISER DANS Commands
			// String argument = commandLine.getArgument();
			// Boolean hasArgument = commandLine.hasArgument();

			String output = "";

			// String[] commandArray = command.trim().split(" ", 2);
			// StringBuilder output = new StringBuilder();

			if (command.equals("exit") || command.equals("logout")) {
				break;

			} else {
				String className = "Commands";
				String methodName = command;
				try {
					// Get the class
					Class<?> myClass = Class.forName(className);

					// Get the constructor
					Constructor<?> constructor = myClass.getDeclaredConstructor();

					// Activate the constructor
					constructor.setAccessible(true);

					// Create instance
					Object instance = constructor.newInstance();

					// Get the method of the class
					Method method = myClass.getMethod(methodName, CommandLine.class);

					// Call the method with the arguments
					Object result = method.invoke(instance, commandLine);
					output = (String) result;

				} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
						| InstantiationException | InvocationTargetException e) {
					// e.printStackTrace();
					output = "Command '" + command + "' not found.";
				}

			}

			System.out.println(output.toString()); // Print with new line (ln)

			System.out.print("> "); // Prompt
		}
		// Forces exit of the while loop
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");

	}

}
