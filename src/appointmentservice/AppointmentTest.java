package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointmentservice.Appointment;

class AppointmentTest {
	
	@Test
	void testAppointmentClass() {
		Appointment appointment= new Appointment("app1", new Date(128, 4, 6), "Description of the first appointment");
		assertTrue(appointment.getAppointmentID().equals("app1"));
		assertTrue(appointment.getDate().equals(new Date(128, 4, 6)));
		assertTrue(appointment.getDescription().equals("Description of the first appointment"));
	}
	
	@Test
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("appointmentIDTooLong", new Date(), "Description of first appointment");
		});
	}
	
	@Test
	void testAppointmentIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, new Date(128, 4, 6), "Description of first appointment");
		});
	}
	

	@Test
	void testDateInvalid() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app2", new Date(120, 4, 6), "Description of app2");
		});
	}
	
	@Test
	void testDateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app3", null, "Description of appointment3");
		});
	}
	@Test
	void appointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app4", new Date(128, 4, 6), "This description is wayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
					+ "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
					+ "yyyyyyyyyyyyyyyyyyyyyyyyyyyy too long man!");
		});
	}
	
	@Test
	void testDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app5", new Date(128, 4, 6), null);
		});
	}
}
