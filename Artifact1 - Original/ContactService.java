package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

import java.util.ArrayList;

//ContactService class
public class ContactService { 
		//Creates variables for objects
		public static String contactServiceID;
		public String contactServiceFirstName;
		public String contactServiceLastName;
		public String contactServicePhone;
		public String contactServiceAddress;
		
		//Creates ArrayList to store contacts data
		static ArrayList<Contact> contactsList = new ArrayList<Contact>(0);
		
		//Generates unique contact ID
		public static String generateUniqueContactID() {
			String uniqueContactID; //String
			
			//If contactsList is empty
			if (contactsList.isEmpty()) {
				contactServiceID = "100"; //Begins with placeholder 100
			}
			
			//Else returns next value in list if list not empty
			else {
				int arraySize = contactsList.size(); //Assigns integer arraySize to equal contactsList size
				contactServiceID = contactsList.get(arraySize - 1).getID();
			}
			
			//Converts string to integer for next value generation
			int nextValueInteger = Integer.valueOf(contactServiceID);
			
			//Increments next value to make unique
			nextValueInteger += 1;
			
			//Converts nextValueInteger back to uniqueContactID
			uniqueContactID = Integer.toString(nextValueInteger);
			
			return uniqueContactID; //Returns uniqueContactID
		}
		
		//Creates a new contact and adds to contactsList
		public static void addNewContact(String contactFirstName,String contactLastName, String contactPhone, String contactAddress) {
			String uniqueID = generateUniqueContactID(); //Creates uniqueID variable
			
			Contact Contact1 = new Contact(uniqueID, contactFirstName, contactLastName, contactPhone, contactAddress); //Defines what variabels to add to a contact
			contactsList.add(Contact1); //Adds to contactsList
			
		}
		
		//Creates new contact manually for testing
		public static void addNewContact(Contact newContact) {
			String tempContactID = newContact.getID(); //Creates tempContactID variable and gets ID
			
			for(int i = 0; i < contactsList.size(); i++) {
				if (tempContactID.equals(contactsList.get(i).getID())) {
					throw new IllegalArgumentException("Contact ID already in use."); //Exception if ID in use
				}
			}
			contactsList.add(newContact); //Adds new contact to contactsList
		}
		
		//Update method for first name field
		public static void updateFirstName(String uniqueContactID, String contactServiceFirstName) {
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0) {
					contactsList.get(i).setFirstName(contactServiceFirstName);
				}
			}
		}
		
		//Update method for last name field
		public static void updateLastName(String uniqueContactID, String contactServiceLastName) {
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0) {
					contactsList.get(i).setLastName(contactServiceLastName);
				}
			}
		}
		
		//Update method for phone number field
		public static void updatePhone(String uniqueContactID, String contactServicePhone) {
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0) {
					contactsList.get(i).setPhone(contactServicePhone);
				}
			}
		}
				
		//Update method for address field
		public static void updateAddress(String uniqueContactID, String contactServiceAddress) {
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0) {
						contactsList.get(i).setAddress(contactServiceAddress);
				}
			}
		}
		
		//Method to delete contact from list
		public void deleteContact(String uniqueContactID) {
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0 ) {
					int contactPosition = i;
					
					contactsList.remove(contactPosition);
				}
			}
		}
		
		//Search method for testing
		public static int searchContactList(String uniqueContactID) {
			int searchResult = 0; //Initializes searchResult to 0
			
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0) {
					searchResult = 1;
				}
				
				else {
					searchResult = -1;
				}
			}
			return searchResult;
		}
		
		//Find index method
		public static int findIndex(String uniqueContactID) {
			int searchResult = 0; //Initializes searchResult to 0
			
			for (int i = 0; i < contactsList.size(); i++) {
				if (uniqueContactID.compareTo(contactsList.get(i).getID()) == 0) {
					searchResult = i;
				}
			}
			return searchResult;
		}
}

