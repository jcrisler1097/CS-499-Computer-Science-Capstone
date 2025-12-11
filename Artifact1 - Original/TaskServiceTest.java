package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	@BeforeEach
	public void setup() {
		TaskService.taskList.clear();
	}

	//Creates a task using TaskService addNewTask method and test values
	@Test
	void testTaskServiceClass() {
		String taskName = "Schedule Appointment";
		String taskDescription = "Schedule date for appointment.";
		
		TaskService test = new TaskService();
		
		assertTrue(TaskService.taskList.isEmpty());
		
		test.addNewTask(taskName, taskDescription);
		assertFalse(TaskService.taskList.isEmpty());
		assertEquals(0, TaskService.taskList.get(0).getTaskID());
		assertEquals(taskName, TaskService.taskList.get(0).getTaskName());
		assertEquals(taskDescription, TaskService.taskList.get(0).getTaskDescription());
	}
	
	//Tests deletion of task
	@Test
	void testTaskServiceDeleteTask() {
		String taskName = "Schedule Appointment";
		String taskDescription = "Schedule date for appointment.";
		
		TaskService test = new TaskService();
		
		assertTrue(TaskService.taskList.isEmpty());
		
		test.addNewTask(taskName, taskDescription);
		test.addNewTask(taskName, taskDescription);
		
		assertEquals(2, TaskService.taskList.size());
		test.deleteTask("0000000001");
		assertTrue(TaskService.searchTaskList("0000000001") == 2);
		assertEquals(1, TaskService.taskList.size());
	}
	
	//Tests update of task name
	@Test
	void testTaskServiceUpdateTaskName() {
		String taskName = "Schedule Appointment";
		String taskDescription = "Schedule date for appointment.";
		int size = TaskService.taskList.size();
		TaskService.updateTaskName("0000000001", "Cancel Appointment");
		assertTrue(TaskService.taskList.get(size - 1).getTaskName().equals("Cancel Appointment"));
	}
	
	//Tests update of task description
	@Test
	void testTaskServiceUpdateTaskDescription() {
		String taskName = "Schedule Appointment";
		String taskDescription = "Schedule date for appointment.";
		int size = TaskService.taskList.size();
		TaskService.updateTaskDescription("0000000001", "Cancel appointment scheduled.");
		assertTrue(TaskService.taskList.get(size - 1).getTaskDescription().equals("Cancel appointment scheduled."));
	}
	
	//Tests for unique task ID
	@Test
	void testTaskServiceUniqueID() {
		String taskName = "Schedule Appointment";
		String taskDescription = "Schedule date for appointment.";
		Task newTask = new Task("0000000001", "Schedule Appointment", "Schedule date for appointment.");
		TaskService.addNewTask(newTask);
		Task duplicateID = new Task("0000000001", "Schedule Appointment", "Schedule date for appointment.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addNewTask(duplicateID);
		});
	}
}

