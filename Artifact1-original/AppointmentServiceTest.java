package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class AppointmentServiceTest {
	
	@BeforeEach
	public void setup() {
		AppointmentService.appointmentList.clear();
	}

	//Creates an appointment using AppointmentService addNewAppointment method and tests values
	@Test
	void testAppointmentServiceClass() {
		Date appointmentDate = new Date();
		String appointmentDescription = "This is the appointment description.";
		
		AppointmentService test = new AppointmentService();
		
		assertTrue(TaskService.taskList.isEmpty());
		
		test.addNewAppointment(appointmentDate, appointmentDescription);
		assertFalse(AppointmentService.appointmentList.isEmpty());
		assertEquals(0, AppointmentService.appointmentList.get(0).getAppointmentID());
		assertEquals(appointmentDate, AppointmentService.appointmentList.get(0).getAppointmentDate());
		assertEquals(appointmentDescription, AppointmentService.appointmentList.get(0).getAppointmentDescription());
	}
	
	//Tests deletion of appointment
	@Test
	void testAppointmentServiceDeleteAppointment() {
		Date appointmentDate = new Date();
		String appointmentDescription = "This is the appointment description.";
		
		AppointmentService test = new AppointmentService();
		
		assertTrue(TaskService.taskList.isEmpty());
		
		test.addNewAppointment(appointmentDate, appointmentDescription);
		test.addNewAppointment(appointmentDate, appointmentDescription);
		
		assertEquals(2, ContactService.contactsList.size());
		test.deleteAppointment("1000000000");
		assertTrue(ContactService.searchContactList("1000000000") == 2);
		assertEquals(1, ContactService.contactsList.size());
	}
	
	//Tests update of appointment date
	@SuppressWarnings("deprecation")
	@Test
	void testAppointmentServiceUpdateDate() {
		Date appointmentDate = new Date();
		String appointmentDescription = "This is the appointment description.";
		int size = AppointmentService.appointmentList.size();
		AppointmentService.updateAppointmentDate("1000000000", (new Date(2027, Calendar.JANUARY, 2)));
		assertTrue(AppointmentService.appointmentList.get(size - 1).getAppointmentDate().equals((new Date(2027, Calendar.JANUARY, 2))));
	}
	
	//Tests update of appointment description
	@Test
	void testAppointmentServiceUpdateDescription() {
		Date appointmentDate = new Date();
		String appointmentDescription = "This is the appointment description.";
		int size = AppointmentService.appointmentList.size();
		AppointmentService.updateAppointmentDescription("1000000000", "This is the new appointment description.");
		assertTrue(AppointmentService.appointmentList.get(size - 1).getAppointmentDescription().equals("This is the new appointment description."));
	}
	
	//Tests for unique appointment ID
	@Test
	void testAppointmentServiceUniqueID() {
		Date appointmentDate = new Date();
		String appointmentDescription = "This is the appointment description.";	
		Appointment newAppointment = new Appointment("10000000000", new Date(), "This is the appointment description.");
		AppointmentService.addNewAppointment(newAppointment);
		Appointment duplicateAppointment = new Appointment("10000000000", new Date(), "This is the appointment description.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService.addNewAppointment(duplicateAppointment);
		});
	}
}

