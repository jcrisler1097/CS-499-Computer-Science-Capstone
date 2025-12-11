package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Conlan
 *  Course: 	 CS-499-14507-M01 Computer Science Capstone 2025 C-6
 *  Date: 		 November 11, 2025
 *  Artifact 1
 * ******/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TaskTest {

	//Tests for creating task
	@Test
	void testTaskClass() {
		String taskID = "0000000002";
		String taskName = "Get Client Name";
		String taskDescription = "Collect client's first and last name.";
		
		Task testTask = new Task(taskID, taskName, taskDescription);
		assertEquals("0000000002", testTask.getTaskID());
		assertEquals("Get Client Name", testTask.getTaskName());
		assertEquals("Collect client's first and last name.", testTask.getTaskDescription());
	}
	
	//Tests for too long ID
	@Test
	void testTaskClassIDLength() {
		String taskID = "0000002340002";
		String taskName = "Get Client Name";
		String taskDescription = "Collect client's first and last name.";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task (taskID, taskName, taskDescription);
		});
	}
	
	//Tests for null ID
	void testTaskClassIDNull() {
		String taskID = null;
		String taskName = "Get Client Name";
		String taskDescription = "Collect client's first and last name.";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDescription);
		});
	}
	
	//Tests for too long task name
	@Test
	void testTaskClassTaskNameLength() {
		String taskID = "0000000002";
		String taskName = "Get Client First and Last Name";
		String taskDescription = "Collect client's first and last name.";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task (taskID, taskName, taskDescription);
		});
	}
	
	//Tests for null task name
	void testTaskClassTaskNameNull() {
		String taskID = "0000000002";
		String taskName = null;
		String taskDescription = "Collect client's first and last name.";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDescription);
		});
	}
	
	//Tests for too long description
	@Test
	void testTaskClassDescriptionLength() {
		String taskID = "0000000002";
		String taskName = "Get Client Name";
		String taskDescription = "Please collect the client's first and last name for all client's and add this information into each task.";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task (taskID, taskName, taskDescription);
		});
	}
	
	//Tests for null description
	void testTaskClassDescriptionNull() {
		String taskID = "0000000002";
		String taskName = "Get Client Name";
		String taskDescription = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDescription);
		});
	}
	
	//Tests setTaskName method
	@Test
	void testTaskClassSetTaskName() {
		String taskID = "0000000003";
		String taskName = "Get Client Address";
		String taskDescription = "Collect client's address.";
		Task newTask = new Task(taskID, taskName, taskDescription);
		newTask.setTaskName("Get Client Phone");
		assertEquals("Get Client Phone", newTask.getTaskName());
	}
	
	//Tests setTaskName method for length
	@Test
	void testTaskClassSetTaskNameLength() {
		String taskID = "0000000003";
		String taskName = "Get Client Address";
		String taskDescription = "Collect client's address.";
		Task newTask = new Task(taskID, taskName, taskDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskName("Get Client's Phone Number");
		});
	}
	
	//Tests setTaskName method for null value
	@Test
	void testTaskClassSetTaskNameNull() {
		String taskID = "0000000003";
		String taskName = "Get Client Address";
		String taskDescription = "Collect client's address.";
		Task newTask = new Task(taskID, taskName, taskDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskName(null);
		});
	}
	
	//Tests setTaskDescription method
	@Test
	void testTaskClassSetTaskDescription() {
		String taskID = "0000000003";
		String taskName = "Get Client Address";
		String taskDescription = "Collect client's address.";
		Task newTask = new Task(taskID, taskName, taskDescription);
		newTask.setTaskName("Collect Client Phone Number");
		assertEquals("Collect Client Phone Number", newTask.getTaskDescription());
	}
	
	//Tests setTaskDescription method for length
	@Test
	void testTaskClassSetTaskDescriptionLength() {
		String taskID = "0000000003";
		String taskName = "Get Client Address";
		String taskDescription = "Collect client's address.";
		Task newTask = new Task(taskID, taskName, taskDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskDescription("Collect Client's Phone Number and add it to their file.");
		});
	}
	
	//Tests setTaskDescription method for null value
	@Test
	void testTaskClassSetTaskDescriptionNull() {
		String taskID = "0000000003";
		String taskName = "Get Client Address";
		String taskDescription = "Collect client's address.";
		Task newTask = new Task(taskID, taskName, taskDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskDescription(null);
		});
	}
}
