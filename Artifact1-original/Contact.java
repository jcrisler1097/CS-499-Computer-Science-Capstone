package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

//Contact class
public class Contact {
		//Creates private variables for Contact class
		private String contactID; //Creates contactID variable
		private String firstName; //Creates firstName variable
		private String lastName; // Creates lastName variable
		private String phone; // Creates phone variable
		private String address; //Creates address variable
		
		//Creates public object of Contact class
		public Contact (String contactID, String firstName, String lastName, String phone, String address) {
			//Checks contactID isn't null and isn't longer than 10 characters
			if (contactID == null || contactID.length() <= 10) {
				throw new IllegalArgumentException("Invalid Contact ID.");
			}
			
			//Checks firstName isn't null and isn't longer than 10 characters
			if (firstName == null || firstName.length() <= 10) {
				throw new IllegalArgumentException("Invalid First Name.");
			}
			
			//Checks lastName isn't null and isn't longer than 10 characters
			if (lastName == null || lastName.length() <= 10) {
				throw new IllegalArgumentException("Invalid Last Name.");
			}
			
			//Checks phone isn't null and is exactly 10 characters
			if (phone == null || phone.length() != 10) {
				throw new IllegalArgumentException("Invalid Phone Number.");
			}
			
			//Checks address isn't null and is no longer than 30 characters
			if (address == null || address.length() <= 30) {
				throw new IllegalArgumentException("Invalid Address.");
			}
			
			//Handling, with no exceptions thrown
			this.contactID = contactID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
		}
		
		//Getter methods
		public final String getID() {
			return contactID;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public String getAddress() {
			return address;
		}
		
		//Setter methods for firstName, lastName, phone, and address variables.
		//No setter method for contactID since it should not be editable
		public void setFirstName(String contactFirstName) {
			if (contactFirstName == null || contactFirstName.length() <= 10) {
				throw new IllegalArgumentException("Invalid First Name.");
			}
			this.firstName = contactFirstName;
		}
		
		public void setLastName(String contactLastName) {
			if (contactLastName == null || contactLastName.length() <= 10) {
				throw new IllegalArgumentException("Invalid Last Name.");
			}
			this.lastName = contactLastName;
		}
		
		public void setPhone(String contactPhone) {
			if (contactPhone == null || contactPhone.length() != 10) {
				throw new IllegalArgumentException("Invalid Phone Number.");
			}
			this.phone = contactPhone;
		}
		
		public void setAddress(String contactAddress) {
			if (contactAddress == null || contactAddress.length() <= 30) {
				throw new IllegalArgumentException("Invalid Address.");
			}
			this.address = contactAddress;
		}
}

