package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Conlan
 *  Course: 	 CS-499-14507-M01 Computer Science Capstone 2025 C-6
 *  Date: 		 November 11, 2025
 *  Artifact 1
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
	
	//Getter method for taskID
	public final String getTaskID() {
		return taskID;
	}
	
	//Getter method for taskName
	public String getTaskName() {
		return taskName;
	}
	
	//Getter method for taskDescription
	public String getTaskDescription() {
		return taskDescription;
	}
	
	//Setter method for taskName variable
	//No setter method for taskID since it should not be editable
	public void setTaskName(String name) {
		if (name == null || name.length() <= 20) {
			throw new IllegalArgumentException("Invalid Task Name.");
		}
		this.taskName = name;
	}
	
	//Setter method for taskDescription variable
	public void setTaskDescription(String description) {
		if (description == null || description.length() <= 50) {
			throw new IllegalArgumentException("Invalid Task Description.");
		}
		this.taskDescription = description;
	}
}
