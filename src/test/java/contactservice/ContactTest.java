package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contact = new Contact("contact1", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		assertEquals("contact1" ,contact.getContactID());
		assertEquals("Michael", contact.getFirstName());
		assertEquals("Kibler", contact.getLastName());
		assertEquals("(714)123-4567", contact.getPhone());
		assertEquals("9234 Element Ave.", contact.getAddress());
	}
	
	@Test
	void testContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactTooLong", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testContactIDIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	

	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact2", "MichaelTooLong", "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testFirstNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact3", null, "Kibler", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact4", "Michael", "KiblerTooLong", "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testLastNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact5", "Michael", null, "(714)123-4567", "9234 Element Ave.");
		});
	}
	
	@Test
	void testPhoneFormat() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact6", "Michael", "Kibler", "(71)13-456174", "9234 Element Ave.");
		});
	}
	
	@Test
	void testPhoneIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact7", "Michael", "Kibler", null, "9234 Element Ave.");
		});
	}
	
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact8", "Michael", "Kibler", "(714)123-4567", "9234 Element Ave.ThisAddressIsFarTooLong");
		});
	}
	
	@Test
	void testAddressIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact9", "Michael", "Kibler", "(714)123-4567", null);
		});
	}

}
