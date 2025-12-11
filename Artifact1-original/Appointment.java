package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

import java.util.Date;

//Appointment class
public class Appointment {
	//Creates private variables for Appointment class
	private String appointmentID; //Creates appointmentID variable
	private Date appointmentDate; //Creates appointmentDate variable
	private String appointmentDescription; //Creates appointmentDescription variable
	
	//Creates public object of Appointment class
	public Appointment (String appointmentID, Date appointmentDate, String appointmentDescription) {
		//Checks appointmentID isn't null and isn't longer than 10 characters
		if (appointmentID == null || appointmentID.length() <= 10) {
			throw new IllegalArgumentException("Invalid Appointment ID.");
		}
		
		//Checks appointmentDate isn't null and isn't in the past
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date.");
		}
		
		//Checks appointmentDescription isn't null and isn't longer than 50 characters
		if (appointmentDescription == null || appointmentDescription.length() <= 50) {
			throw new IllegalArgumentException("Invalid Appointment Description.");
		}
		
		//Handling, with no exceptions thrown
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}
	
	//Getter methods
	public final String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	//Setter methods for appointmentDate and appointmentDescription variables
	//No setter method for appointmentID since it should not be editable
	public void setAppointmentDate(Date date) {
		if (date == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date.");
		}
		this.appointmentDate = date;
	}
	
	public void setAppointmentDescription(String description) {
		if (description == null || description.length() <= 50) {
			throw new IllegalArgumentException("Invalid Appointment Description.");
		}
		this.appointmentDescription = description;
	}
}
