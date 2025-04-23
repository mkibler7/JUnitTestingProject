package contactservice;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	
//	private static final Set<String> contacts = new HashSet<>();
	
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	Contact (String contactID, String firstName, String lastName, String phone, String address) {
		
		// Validate contactID using project requirements
		
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID.");
		}
		this.contactID = contactID;
		
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
		
	}

	public String getContactID() {											// contactID getter, no setter as variable is final
		return contactID;
	}

	public String getFirstName() {											// firstName getter/setter
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		// Validate firstName using project requirements
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName.");
		}
		
		this.firstName = firstName;
	}

	public String getLastName() {											// lastName getter/setter
		return lastName;
	}

	public void setLastName(String lastName) {
		
		// Validate lastName using project requirements
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName.");
		}
		
		this.lastName = lastName;
	}

	public String getPhone() {												// phone getter/setter
		return phone;
	}

	public void setPhone(String phone) {
		
		// Validate phone using project requirements
		if (phone == null || !phone.matches("\\(\\d{3}\\)\\d{3}\\-\\d{4}")) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		
		this.phone = phone;
	}

	public String getAddress() {											// address getter/setter
		return address;
	}

	public void setAddress(String address) {
		
		// Validate address using project requirements
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		
		this.address = address;
	}

}