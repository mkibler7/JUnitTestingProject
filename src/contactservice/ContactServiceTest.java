package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentservice.Appointment;
import appointmentservice.AppointmentService;

class ContactServiceTest {

	ContactService service;
	Contact contact;
	
	@BeforeEach
	void setup() {
		service = new ContactService();
		contact = new Contact("contact1", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		service.addContact(contact);
	}

	
	@Test
	void testAddContact() {
		
		
		Contact retrieved = service.getContact("contact1");
		assertTrue(retrieved.getFirstName().equals("Michael"));
	}
	
	@Test 
	void testAddContactDuplicateID() {
		
		Contact contact2 = new Contact("contact1", "Paul", "Smith", "(143)456-7890", "1052 Lily Ave.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	@Test 
	void testDeleteContact() {
	
		service.deleteContact("contact1");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("contact1");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		
		service.updateFirstName("contact1", "Paul");
		
		assertTrue(contact.getFirstName().equals("Paul"));
		
	}
	
	@Test
	void testUpdateLastName() {
	
		service.updateLastName("contact1", "Roger");
		
		assertTrue(contact.getLastName().equals("Roger"));
		
	}
	
	@Test
	void testUpdatePhone() {
		
		service.updatePhone("contact1", "(714)321-4567");
		
		assertTrue(contact.getPhone().equals("(714)321-4567"));
		
	}
	
	@Test
	void testUpdateAddress() {
		
		service.updateAddress("contact1", "1234 Helmet St.");
		
		assertTrue(contact.getAddress().equals("1234 Helmet St."));
		
	}
	
	@Test 
	void testGetContact() {
		
		Contact returned = service.getContact("contact1");
		
		assertTrue(returned.getFirstName().equals("Michael"));	
		assertTrue(returned.getLastName().equals("Kibler"));
		assertTrue(returned.getPhone().equals("(714)123-4567"));
		assertTrue(returned.getAddress().equals("9234 Element Ave."));
	}
		
	@Test 
	void testGetContactIsNull() {
		
		service.deleteContact("contact1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("contact1");
		});
	}
}
