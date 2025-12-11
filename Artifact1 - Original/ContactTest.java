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
import org.junit.jupiter.api.Test;

class ContactTest {

	//Tests for creating contact
	@Test
	void testContactClass() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phone, address);
		assertEquals(contactID, testContact.getID());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phone, testContact.getPhone());
		assertEquals(address, testContact.getAddress());
	}
	
	//Tests for too long ID
	@Test
	void testContactClassIDLength() {
		String contactID = "101010101010101011";
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phone, address);
			
		});
	}
	
	//Tests for null ID
	@Test
	void testContactClassIDNull() {
		String contactID = null;
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests first name length
	@Test
	void testContactClassFirstNameLength() {
		String contactID = "101";
		String firstName = "JordanCrisler";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests for null first name
	@Test
	void testContactClassFirstNameNull() {
		String contactID = "101";
		String firstName = null;
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests last name length
	@Test
	void testContactClassLastNameLength() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = "CrislerJordan";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests for null last name
	@Test
	void testContactClassLastNameNull() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = null;
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests phone number length
	@Test
	void testContactClassPhoneLength() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "817564375876251";
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests for null phone number
	@Test
	void testContactClassPhoneNull() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = null;
		String address = "185 Evans St, Denver, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests address length
	@Test
	void testContactClassAddressLength() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "1685 Cowles Ave, Longmont, CO 80504";
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests for null address
	@Test
	void testContactClassAddressNull() {
		String contactID = "101";
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = null;
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(contactID, firstName, lastName, phone, address);
		});
	}
	
	//Tests setFirstName method
	@Test
	void testContactClassSetFirstName() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		newContact.setFirstName("Scott");
		assertEquals("Scott", newContact.getFirstName());
	}
	
	@Test
	void testContactClassSetFirstNameLength() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("JesseCrisler");
		});
	}

	@Test
	void testContactClassSetFirstNameNull() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}	
	
	//Tests setLastName method
	@Test
	void testContactClassSetLastName() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		newContact.setLastName("Thomas");
		assertNotEquals("Crisler", newContact.getLastName());
	}
	
	@Test
	void testContactClassSetLastNameLength() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("JesseCrisler");
		});
	}

	@Test
	void testContactClassSetLastNameNull() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	
	//Tests setPhone method
	@Test
	void testContactClassSetPhone() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		newContact.setPhone("2803025813");
		assertNotEquals("9703025813", newContact.getPhone());
	}
	
	@Test
	void testContactClassSetPhoneLength() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("97030258132");
		});
	}

	@Test
	void testContactClassSetPhoneNull() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}
	
	//Tests setAddress method
	@Test
	void testContactClassSetAddress() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		newContact.setAddress("791 Newport Rd, Erie, CO 85702");
		assertNotEquals("324 Colfax St, Erie, CO 85402", newContact.getAddress());
	}
	
	@Test
	void testContactClassSetAddressLength() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("67823 Independence Cir, Boulder, CO 85140");
		});
	}

	@Test
	void testContactClassSetAddressNull() {
		String contactID = "102";
		String firstName = "Jesse";
		String lastName = "Crisler";
		String phone = "9703025813";
		String address = "324 Colfax St, Erie, CO 85402";
		Contact newContact = new Contact (contactID, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
}
