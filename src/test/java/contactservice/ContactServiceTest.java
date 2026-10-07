package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
		assertEquals("Michael", retrieved.getFirstName());
	}
	
	@Test 
	void testAddContactDuplicateID() {
		
		Contact contact2 = new Contact("contact1", "Paul", "Smith", "(143)456-7890", "1052 Lily Ave.");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	@Test 
	void testDeleteContact() {
	
		service.deleteContact("contact1");
	
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("contact1");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		
		service.updateFirstName("contact1", "Paul");
		
		assertEquals("Paul", contact.getFirstName());
	}
	
	@Test
	void testUpdateLastName() {
	
		service.updateLastName("contact1", "Roger");
		
		assertEquals("Roger", contact.getLastName());
	}
	
	@Test
	void testUpdatePhone() {
		
		service.updatePhone("contact1", "(714)321-4567");
		
		assertEquals("(714)321-4567", contact.getPhone());
	}
	
	@Test
	void testUpdateAddress() {
		
		service.updateAddress("contact1", "1234 Helmet St.");
		
		assertEquals("1234 Helmet St.", contact.getAddress());
	}
	
	@Test 
	void testGetContact() {
		
		Contact returned = service.getContact("contact1");
		
		assertEquals("Michael", returned.getFirstName());	
		assertEquals("Kibler", returned.getLastName());
		assertEquals("(714)123-4567", returned.getPhone());
		assertEquals("9234 Element Ave.", returned.getAddress());
	}
		
	@Test 
	void testGetContactIsNull() {
		
		service.deleteContact("contact1");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("contact1");
		});
	}
}
