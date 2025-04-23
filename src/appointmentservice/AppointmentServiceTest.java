package appointmentservice;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	AppointmentService service;
	Appointment appointment;
	
	@BeforeEach
	void setup() {
		service = new AppointmentService();
		appointment = new Appointment("app1", new Date(128, 4, 6), "Appointment Description.");
	}


	@Test
	void testAddAppointment() {
		
		service.addAppointment(appointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment);
		});
		
		Appointment retrieved = service.getAppointment("app1");
	
		assertTrue(retrieved.getAppointmentID().equals("app1"));
		assertTrue(retrieved.getDate().equals(new Date(128, 4, 6)));
		assertTrue(retrieved.getDescription().equals("Appointment Description."));
	}
	
	@Test 
	void testAddAppointmentDuplicateID() {
		service.addAppointment(appointment);
		
		Appointment appointment2 = new Appointment("app1", new Date(), "Appointment Description.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment2);
		});
	}
	
	@Test 
	void testDeleteAppointment() {		
		service.addAppointment(appointment);
		
		service.deleteAppointment("app1");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("app1");
		});
	}
	
	

	@Test 
	void testGetAppointment() {
		
		service.addAppointment(appointment);
		
		Appointment returned = service.getAppointment("app1");
		
		assertTrue(returned.getAppointmentID().equals("app1"));	
		assertTrue(returned.getDate().equals(new Date(128, 4, 6)));
		assertTrue(returned.getDescription().equals("Appointment Description."));
	}
		
	@Test 
	void testGetTaskIsNull() {

		service.addAppointment(appointment);
		
		service.deleteAppointment("app1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment("app1");
		});
	}
}
