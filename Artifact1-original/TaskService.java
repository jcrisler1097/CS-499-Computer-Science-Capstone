package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

import java.util.ArrayList;

//TaskService class
public class TaskService {
	//Create variables for objects in TaskService class
	public static String taskServiceID;
	public String taskServiceName;
	public String taskServiceDescription;
	
	//Creates ArrayList to store tasks data
	static ArrayList<Task> taskList = new ArrayList<Task>(0);
	
	//Generate unique task ID
	public static String generateUniqueTaskID() {
		String uniqueTaskID; //String uniqueTaskID
		
		//If taskList is empty
		if (taskList.isEmpty()) {
			taskServiceID = "0000000001"; //Placeholder 0000000001 for beginning
		}
		
		//Else returns next value in list if list isn't empty
		else {
			int arraySize = taskList.size(); //Assigns integer arraySzie with taskList size
			taskServiceID = taskList.get(arraySize - 1).getTaskID();
		}
		
		//Converts string to integer for next taskServiceID value generation
		int getNextValue = Integer.valueOf(taskServiceID);
		
		//Makes unique by incrementing next value
		getNextValue += 1;
		
		//Converts getNetValue back to uniqueTaskID
		uniqueTaskID = Integer.toString(getNextValue);
		
		return uniqueTaskID; //Returns uniqueTaskID
	}
	
	//Creates a new task and adds to taskList
	public static void addNewTask(String name, String description) {
		String uniqueID = generateUniqueTaskID(); //Creates uniqueID variable 
		
		Task Task1 = new Task(uniqueID, name, description); //Defines what variables are to be added to a task
		taskList.add(Task1); //Adds to taskList
	}
	
	//Creates new task manually for testing
	public static void addNewTask(Task newTask) {
		String tempTaskID = newTask.getTaskID(); //Creates tempTaskID variable and gets task ID
		
		for (int i = 0; i < taskList.size(); i++) {
			if (tempTaskID.equals(taskList.get(i).getTaskID())) {
				throw new IllegalArgumentException("Task ID already in use."); //Exception if task ID already in use
			}
		}
		taskList.add(newTask); //Adds new task to taskList
	}
	
	//Update method for task name
	public static void updateTaskName(String uniqueTaskID, String taskServiceName) {
		for (int i = 0; i < taskList.size(); i++) {
			if (uniqueTaskID.compareTo(taskList.get(i).getTaskID()) == 0) {
				taskList.get(i).setTaskName(taskServiceName);
			}
		}
	}
	
	//Update method for task description
	public static void updateTaskDescription(String uniqueTaskID, String taskServiceDescription) {
		for (int i = 0; i < taskList.size(); i++) {
			if (uniqueTaskID.compareTo(taskList.get(i).getTaskID()) == 0) {
				taskList.get(i).setTaskName(taskServiceDescription);
			}
		}
	}
	
	//Method to delete task from list
	public static void deleteTask(String uniqueTaskID) {
		for (int i = 0; i < taskList.size(); i++) {
			if (uniqueTaskID.compareTo(taskList.get(i).getTaskID()) == 0) {
				int taskPosition = i;
				
				taskList.remove(taskPosition);
			}
		}
	}
	
	//Search method for testing
	public static int searchTaskList(String uniqueTaskID) {
		int searchResult = 0; //Initializes searchResult to 0
		
		for (int i = 0; i < taskList.size(); i++) {
			if (uniqueTaskID.compareTo(taskList.get(i).getTaskID()) == 0) {
				searchResult = 1;
			}
			
			else {
				searchResult = 2;
			}
		}
		return searchResult;
	}
	
	//Method to find index
	public static int findIndex(String uniqueTaskID) {
		int searchResult = 0; //Initializes searchResult to 0
		
		for (int i = 0; i < taskList.size(); i++) {
			if (uniqueTaskID.compareTo(taskList.get(i).getTaskID()) == 0) {
				searchResult = i;
			}
		}
		return searchResult;
	}
}

