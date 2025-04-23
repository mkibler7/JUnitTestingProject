package appointmentservice;

import java.util.HashMap;
import java.util.Map;

import appointmentservice.Appointment;

public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	public void addAppointment(Appointment appointment) {	
	
		if (appointments.containsKey(appointment.getAppointmentID())) {
			throw new IllegalArgumentException("Already an appointment with that ID.");
		}
		appointments.put(appointment.getAppointmentID(), appointment);
	}
	
	public void deleteAppointment(String appointmentID) {
		if (!appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("appointmentID doesn't exist.");
		}
		appointments.remove(appointmentID);
	}
	
	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = appointments.get(appointmentID);
		if (appointment == null) {
			throw new IllegalArgumentException("Invalid appointment ID. No appointment with that ID has been created.");
		}
		return appointment;
	}
}


