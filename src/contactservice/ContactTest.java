package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contact = new Contact("contact1", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		assertTrue(contact.getContactID().equals("contact1"));
		assertTrue(contact.getFirstName().equals("Michael"));
		assertTrue(contact.getLastName().equals("Kibler"));
		assertTrue(contact.getPhone().equals("(714)123-4567"));
		assertTrue(contact.getAddress().equals("9234 Element Ave."));
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactTooLong", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testContactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	

	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact2", "MichaelTooLong", "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact3", null, "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact4", "Michael", "KiblerTooLong", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact5", "Michael", null, "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testPhoneFormat() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact6", "Michael", "Kibler", "(71)13-456174", "9234 Element Ave.");
		});
	}
	
	@Test
	void testPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact7", "Michael", "Kibler", null, "9234 Element Ave.");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact8", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.ThisAddressIsFarTooLong");
		});
	}
	
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact9", "Michael", "Kibler", "(714)123-4567", null);
		});
	}

}
