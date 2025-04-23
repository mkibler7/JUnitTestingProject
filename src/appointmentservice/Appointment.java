package appointmentservice;

import java.util.Date;

public class Appointment {
	String appointmentID;
	Date date;
	String description;
	
	Appointment(String appointmentID, Date date, String description) {
		
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
	
	public void setDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid date.");
		}
		this.date = date;
		
	}
	
	public Date getDate() {
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

