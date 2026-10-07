package appointmentservice;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	AppointmentService service;
	Appointment appointment;
	LocalDateTime futureDate;
	
	@BeforeEach
	void setup() {
		service = new AppointmentService();
		futureDate = LocalDateTime.now().plusDays(30);
		appointment = new Appointment("app1", futureDate, "Appointment Description.");
	}


	@Test
	void testAddAppointment() {
		
		service.addAppointment(appointment);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment);
		});
		
		Appointment retrieved = service.getAppointment("app1");
	
		assertEquals("app1", retrieved.getAppointmentID());
		assertEquals(futureDate, retrieved.getDate());
		assertEquals("Appointment Description.", retrieved.getDescription());
	}
	
	@Test 
	void testAddAppointmentDuplicateID() {
		service.addAppointment(appointment);
		
		Appointment appointment2 = new Appointment("app1", futureDate, "Appointment Description.");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment2);
		});
	}
	
	@Test 
	void testDeleteAppointment() {		
		service.addAppointment(appointment);
		
		service.deleteAppointment("app1");
	
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("app1");
		});
	}
	
	

	@Test 
	void testGetAppointment() {
		
		service.addAppointment(appointment);
		
		Appointment returned = service.getAppointment("app1");
		
		assertEquals("app1", returned.getAppointmentID());
		assertEquals(futureDate, returned.getDate());
		assertEquals("Appointment Description.", returned.getDescription());
	}
		
	@Test 
	void testGetDeletedAppointmentThrows() {

		service.addAppointment(appointment);
		
		service.deleteAppointment("app1");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment("app1");
		});
	}
}
