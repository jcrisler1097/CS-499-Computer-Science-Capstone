package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Conlan
 *  Course: 	 CS-499-14507-M01 Computer Science Capstone 2025 C-6
 *  Date: 		 November 11, 2025
 *  Artifact 1
 * ******/

import java.util.ArrayList;
import java.util.Date;

//AppointmentService class
public class AppointmentService {
	//Creates variables for objects in AppointmentService class
	public static String appointmentServiceID; //Creates appointmentServiceID variable
	public Date appointmentServiceDate; //Creates appointmentServiceDate variable
	public String appointmentServiceDescription; //Create appointmentServiceDescription variable
	
	//Creates ArrayList to store appointments data
	static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(0);
	
	//Generates unique appointment ID
	public static String generateUniqueAppointmentID() {
		String uniqueAppointmentID; //String uniqueAppointmentID
		
		//If appointmentList is empty
		if (appointmentList.isEmpty()) {
			appointmentServiceID = "1000000000"; //Placeholder 10000000000 for beginning
		}
		
		//Else returns value in list if list isn't empty
		else {
		int arraySize = appointmentList.size(); //Assigns integer to arraySize with appointmenList size
		appointmentServiceID = appointmentList.get(arraySize - 1).getAppointmentID();
		}
		
		//Converts string to integer for next appointmentServiceID value generation
		int getNextIDValue = Integer.valueOf(appointmentServiceID);
		
		//Make unique by incrementing next value
		getNextIDValue += 1;
		
		//Converts getNextIDValue back to uniqueAppointmentID
		uniqueAppointmentID = Integer.toString(getNextIDValue);
		
		return uniqueAppointmentID; //Returns uniqueAppointmentID
	}
	
	//Checks for duplicate entries with array list and throws exception if duplicate is found
	private static void checkDuplicateEntry(String ID) {
	    for (Appointment appointment : appointmentList) {
	        if (appointment.getAppointmentID().equals(ID)) {
	            throw new IllegalArgumentException("Error: Duplicate appointment ID found: " + ID);
	        }
	    }
	}
	
	//Creates a new appointment and adds to appointmentsList
	public static void addNewAppointment(Date date, String description) {
		String uniqueID = generateUniqueAppointmentID(); //Creates uniqueID variable
		
		//Calls checkDupleicateEntry method to check for duplicate entries before creating new appointment
		checkDuplicateEntry(uniqueID);
		
		Appointment Appointment1 = new Appointment(uniqueID, date, description); //Defines what variables are added to a new appointment
		appointmentList.add(Appointment1); //Adds to appointmentList
	}
	
	//Creates new appointment manually for testing
	public static void addNewAppointment(Appointment newAppointment) {
		String tempAppointmentID = newAppointment.getAppointmentID(); //Creates tempAppointmentID variable and gets appointment ID
		
		for (int i = 0; i < appointmentList.size(); i++) {
			if (tempAppointmentID.equals(appointmentList.get(i).getAppointmentID())) {
				throw new IllegalArgumentException("Appointment ID already in use."); //Exception if appointment ID already in use
			}
		}
		appointmentList.add(newAppointment); //Adds new appointment to appointmentList
	}
	
	//Update method for appointment date
	public static void updateAppointmentDate(String uniqueAppointmentID, Date appointmentServiceDate) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentID.compareTo(appointmentList.get(i).getAppointmentID()) == 0) {
				appointmentList.get(i).setAppointmentDate(appointmentServiceDate);
			}
		}
	}
	
	//Update method for appointment description
	public static void updateAppointmentDescription(String uniqueAppointmentID, String appointmentServiceDescription) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentID.compareTo(appointmentList.get(i).getAppointmentID()) == 0) {
				appointmentList.get(i).setAppointmentDescription(appointmentServiceDescription);
			}
		}
	}
	
	//Method to delete appointment from list
	public static void deleteAppointment(String uniqueAppointmentID) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentID.compareTo(appointmentList.get(i).getAppointmentID()) == 0) {
				int appointmentPosition = i;
				
				appointmentList.remove(appointmentPosition);
			}
		}
	}
	
	//Search method for testing for searching by ID
	public static int searchAppointmentList(String uniqueAppointmentID) {
		int searchResult = 0; //Initializes searchResult to 0
		
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentID.compareTo(appointmentList.get(i).getAppointmentID()) == 0) {
				searchResult = 1;
			}
			
			else {
				searchResult = 2;
			}
		}
		return searchResult;
	}
	
	//Search method for testing for searching by date
	public static int searchAppointmentListDate(Date uniqueAppointmentDate) {
		int searchResult = 0; //Initializes searchResult to 0
		
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentDate.compareTo(appointmentList.get(i).getAppointmentDate()) == 0) {
				searchResult = 1;
			}
			
			else {
				searchResult = 2;
			}
		}
		return searchResult;
	}
	
	//Search method for testing for searching by description
	public static int searchAppointmentListDescription(String uniqueAppointmentDescription) {
		int searchResult = 0; //Initializes searchResult to 0
		
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentDescription.compareTo(appointmentList.get(i).getAppointmentDescription()) == 0) {
				searchResult = 1;
			}
			
			else {
				searchResult = 2;
			}
		}
		return searchResult;
	}
	
	//Method for finding index
	public static int findIndex(String uniqueAppointmentID) {
		int searchResult = 0; //Initializes searchResult to 0
		
		for (int i = 0; i < appointmentList.size(); i++) {
			if (uniqueAppointmentID.compareTo(appointmentList.get(i).getAppointmentID()) == 0) {
				searchResult = i;
			}
		}
		return searchResult;
	}
}

