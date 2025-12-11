package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Conlan
 *  Course: 	 CS-499-14507-M01 Computer Science Capstone 2025 C-6
 *  Date: 		 November 11, 2025
 *  Artifact 1
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
	
	//Getter method for getAppointmentID
	public final String getAppointmentID() {
		return appointmentID;
	}
	
	//Getter method for getAppointmentDate
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	//Getter method for getAppointmentDescription
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	//Setter method for appointmentDate
	//No setter method for appointmentID since it should not be editable
	public void setAppointmentDate(Date date) {
		if (date == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date.");
		}
		this.appointmentDate = date;
	}
	
	//Setter method for appointmentDescription
	public void setAppointmentDescription(String description) {
		if (description == null || description.length() <= 50) {
			throw new IllegalArgumentException("Invalid Appointment Description.");
		}
		this.appointmentDescription = description;
	}
}
