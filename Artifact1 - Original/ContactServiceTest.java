package projectOne;

/******
 *  Name:		 Jordan Crisler
 *  Professor: 	 Professor Lewis
 *  Course: 	 CS-320-10080-M01 Software Test, Automation QA 2025 C-2
 *  Date: 		 April 11, 2025
 *  Assignment:  Project One
 * ******/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class ContactServiceTest {
	
	@BeforeEach
	public void setup() {
		ContactService.contactsList.clear();
	}

	//Creates a contact using ContactService addNewContact method and test values
	@Test
	void testContactServiceClass() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		
		ContactService test = new ContactService();
		
		assertTrue(ContactService.contactsList.isEmpty());
		
		test.addNewContact(firstName, lastName, phone, address);
		assertFalse(ContactService.contactsList.isEmpty());
		assertEquals(0, ContactService.contactsList.get(0).getID());
		assertEquals(firstName, ContactService.contactsList.get(0).getFirstName());
		assertEquals(lastName, ContactService.contactsList.get(0).getLastName());
		assertEquals(phone, ContactService.contactsList.get(0).getPhone());
		assertEquals(address, ContactService.contactsList.get(0).getAddress());
	}

	//Tests deletion of contact
	@Test
	void testContactServiceDeleteContact() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		
		ContactService test = new ContactService();
		
		assertTrue(ContactService.contactsList.isEmpty());
		
		test.addNewContact(firstName, lastName, phone, address);
		test.addNewContact(firstName, lastName, phone, address);
		
		assertEquals(2, ContactService.contactsList.size());
		test.deleteContact("101");
		assertTrue(ContactService.searchContactList("101") == 2);
		assertEquals(1, ContactService.contactsList.size());
	}
	
	//Tests update of first name
	@Test
	void testContactServiceUpdateFirstName() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		int size = ContactService.contactsList.size();
		ContactService.updateFirstName("101", "Jesse");
		assertTrue(ContactService.contactsList.get(size - 1).getFirstName().equals("Jesse"));
	}
	
	//Tests update of last name
	@Test
	void testContactServiceUpdateLastName() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		int size = ContactService.contactsList.size();
		ContactService.updateLastName("101", "Thomas");
		assertTrue(ContactService.contactsList.get(size - 1).getLastName().equals("Thomas"));
	}
	
	//Tests update of phone number
	@Test
	void testContactServiceUpdatePhone() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		int index = ContactService.findIndex("101");
		ContactService.updatePhone("101", "9703025815");
		assertTrue(ContactService.contactsList.get(index).getPhone().equals("9703025815"));
	}
	
	//Tests update of address
	@Test
	void testContactServiceUpdateAddress() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		int index = ContactService.findIndex("101");
		ContactService.updateAddress("101", "185 Evans St, Denver, CO 80504");
		assertTrue(ContactService.contactsList.get(index).getAddress().equals("185 Evans St, Denver, CO 80504"));
	}
	
	//Tests for unique ID
	void testContactServiceUniqueID() {
		String firstName = "Jordan";
		String lastName = "Crisler";
		String phone = "8175643758";
		String address = "185 Evans St, Denver, CO 80504";
		Contact newContact = new Contact("101", firstName, lastName, phone, address);
		ContactService.addNewContact(newContact);
		Contact duplicateID = new Contact("101", firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addNewContact(duplicateID);
		});
	}
}

