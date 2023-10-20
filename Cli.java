import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cli {

	public static void main(String[] args) {
		String sep = System.lineSeparator();
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
					// Obtenir la classe
					Class<?> clazz = Class.forName(className);

					// Obtenir le constructeur approprié (par exemple, un constructeur avec des
					// arguments)
					Constructor<?> constructor = clazz.getDeclaredConstructor();

					// Activer l'accès au constructeur si nécessaire (si le constructeur est privé,
					// etc.)
					constructor.setAccessible(true);

					// Créer une instance en utilisant le constructeur et en fournissant les
					// arguments appropriés
					Object instance = constructor.newInstance();

					// Obtenir la méthode à partir de la classe
					Method method = clazz.getMethod(methodName, CommandLine.class);

					// Appeler la méthode
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
