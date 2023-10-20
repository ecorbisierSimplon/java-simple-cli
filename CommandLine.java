public class CommandLine {
	private String command = "";
	private String argument = "";
	
	CommandLine (String commandExtract){
		String[] commandArray = commandExtract.trim().split(" ", 2);
		command = commandArray[0].trim();
		argument = commandArray.length > 1 ? commandArray[1].trim() : "";
	}
	
	public String getCommand(){
		return command;
	}
	
	public String getArgument(){
		return argument;
	}
	
	public boolean hasArgument(){
		return !argument.isEmpty();
	}
	
	
	
}