package contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Already a contact with that ID.");
		}
		contacts.put(contact.getContactID(), contact);
	}
	
	public void deleteContact(String contactID) {
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("contactID does't exist.");
		}
		contacts.remove(contactID);
	}
	
	public void updateFirstName(String contactID, String firstName) {
		getContact(contactID).setFirstName(firstName);
	}
	
	public void updateLastName(String contactID, String lastName) {
		getContact(contactID).setLastName(lastName);
	}
	
	public void updatePhone(String contactID, String phone) {
		getContact(contactID).setPhone(phone);
	}
	
	public void updateAddress(String contactID, String address) {
		getContact(contactID).setAddress(address);
	}
	
	public Contact getContact(String contactID) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Invalid contact ID. No contact with that ID has been created.");
		}
		return contact;
	}

}