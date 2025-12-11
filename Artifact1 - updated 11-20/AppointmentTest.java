package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Conlan
 *  Course: 	 CS-499-14507-M01 Computer Science Capstone 2025 C-6
 *  Date: 		 November 11, 2025
 *  Artifact 1
 * ******/

import java.util.Date;
import java.util.Calendar;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AppointmentTest {
	
	@SuppressWarnings("deprecation")
	//Tests for creating appointment
	@Test
	void testGetAppointmentID() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		assertEquals("0123456789", newAppointment.getAppointmentID());
		assertEquals(new Date(2026, Calendar.JANUARY, 2), newAppointment.getAppointmentDate());
		assertEquals("The appointment object description would go here.", newAppointment.getAppointmentDescription());
	}
	
	@SuppressWarnings("deprecation")
	//Tests for too long ID
	@Test
	void testTooLongAppointmentID() {
		String appointmentID = "0123456789123456";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDescription);
		});
	}
	
	@SuppressWarnings("deprecation")
	//Tests for null ID
	@Test
	void testNullAppointmentID() {
		String appointmentID = null;
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDescription);
		});
	}
	
	@SuppressWarnings("deprecation")
	//Tests for date in the past
	@Test
	void testPastDateAppointmentDate() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2001, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDescription);
		});
	}
	
	//Tests for null date
	@Test
	void testNullAppointmentDate() {
		String appointmentID = "0123456789";
		Date appointmentDate = null;
		String appointmentDescription = "The appointment object description would go here.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDescription);
		});
	}
	
	@SuppressWarnings("deprecation")
	//Tests for null description
	@Test
	void testNullAppointmentDescription() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDescription);
		});
	}
	
	@SuppressWarnings("deprecation")
	//Tests for too long description
	@Test
	void testTooLongAppointmentDescription() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here, but this one is too long.";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDescription);
		});
	}
	
	//Tests setAppointmentDate method
	@SuppressWarnings("deprecation")
	@Test
	void testsetAppointmentDate() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		newAppointment.setAppointmentDate(new Date(2027, Calendar.JANUARY, 2));
		assertEquals(new Date(2027, Calendar.JANUARY, 2), newAppointment.getAppointmentDate());
	}
	
	//Tests setAppointmentDate method for null value
	@SuppressWarnings("deprecation")
	@Test
	void testsetAppointmentDateNull() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointment.setAppointmentDate(null);
		});
	}
	
	//Tests setAppointmentDate method for in the past date
	@SuppressWarnings("deprecation")
	@Test
	void testsetAppointmentDateInPast() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointment.setAppointmentDate(new Date(2001, Calendar.JANUARY, 2));
		});
	}
	
	//Tests setAppointmentDescription method
	@SuppressWarnings("deprecation")
	@Test
	void testsetAppointmentDescription() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		newAppointment.setAppointmentDescription("This will be the new description.");
		assertEquals("This will be the new description.", newAppointment.getAppointmentDescription());
	}
	
	//Tests setAppointmentDescription for null value
	@SuppressWarnings("deprecation")
	@Test
	void testsetAppointmentDescriptionNull() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointment.setAppointmentDescription(null);
		});
	}
	
	//Tests setAppointmentDescription value for too long in length
	@SuppressWarnings("deprecation")
	@Test
	void testsetAppointmentDescriptionTooLong() {
		String appointmentID = "0123456789";
		Date appointmentDate = new Date(2026, Calendar.JANUARY, 2);
		String appointmentDescription = "The appointment object description would go here.";
		
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointment.setAppointmentDescription("This description for the appointment will be too long.");
		});
	}
}

