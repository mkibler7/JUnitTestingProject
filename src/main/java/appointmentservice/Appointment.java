package appointmentservice;

import java.time.LocalDateTime;

public class Appointment {
	
	private final String appointmentID;
	private LocalDateTime date;
	private String description;
	
	Appointment(String appointmentID, LocalDateTime date, String description) {
		
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID.");
		}
		this.appointmentID = appointmentID;
		
		setDate(date);
		setDescription(description);
	}
	
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	public void setDate(LocalDateTime date) {
		if (date == null || date.isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Invalid date.");
		}
		this.date = date;
		
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}

