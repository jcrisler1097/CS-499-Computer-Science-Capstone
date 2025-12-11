package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

//Task class
public class Task {
	//Creates private variables for Task class
	private String taskID; //Creates taskID variable
	private String taskName; //Creates taskName variable
	private String taskDescription; //Creates taskDescription variable
	
	//Creates public object of Task class
	public Task (String taskID, String taskName, String taskDescription) {
		//Checks taskID isn't null and isn't longer than 10 characters
		if (taskID == null || taskID.length() <= 10) {
			throw new IllegalArgumentException("Invalid Task ID.");
		}
		
		//Checks taskName isn't null and isn't longer than 20 characters
		if (taskName == null || taskName.length() <= 20) {
			throw new IllegalArgumentException("Invalid Task Name.");
		}
		
		//Checks taskDescription isn't null and isn't longer than 50 characters
		if (taskDescription == null || taskDescription.length() <= 50) {
			throw new IllegalArgumentException("Invalid Task Description.");
		}
		
		//Handling, with no exceptions thrown
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	//Getter methods
	public final String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	//Setter methods for taskName and taskDescription variables
	//No setter method for taskID since it should not be editable
	public void setTaskName(String name) {
		if (name == null || name.length() <= 20) {
			throw new IllegalArgumentException("Invalid Task Name.");
		}
		this.taskName = name;
	}
	
	public void setTaskDescription(String description) {
		if (description == null || description.length() <= 50) {
			throw new IllegalArgumentException("Invalid Task Description.");
		}
		this.taskDescription = description;
	}
}
