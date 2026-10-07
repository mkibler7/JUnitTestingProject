package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AppointmentTest {

	LocalDateTime futureDate;
	
	@BeforeEach
	void setup() {
		futureDate = LocalDateTime.now().plusDays(30);
	}
	
	@Test
	void testAppointmentClass() {
		Appointment appointment = new Appointment("app1", futureDate, "Description of the first appointment");
		assertEquals("app1", appointment.getAppointmentID());
		assertEquals(futureDate, appointment.getDate());
		assertEquals("Description of the first appointment", appointment.getDescription());
	}
	
	@Test
	void testAppointmentIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("appointmentIDTooLong", futureDate, "Description of first appointment");
		});
	}
	
	@Test
	void testAppointmentIDIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "Description of first appointment");
		});
	}
	

	@Test
	void testDateInPast() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app2", LocalDateTime.now().minusDays(1), "Description of app2");
		});
	}
	
	@Test
	void testDateIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app3", null, "Description of appointment3");
		});
	}

	@Test
	void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app4", futureDate, "tooLong".repeat(10));
		});
	}
	
	@Test
	void testDescriptionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("app5", futureDate, null);
		});
	}
}
