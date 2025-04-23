package taskservice;

public class Task {
	String taskID;
	String name;
	String description;
	
	Task(String taskID, String name, String description) {
		
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid Task ID.");
		}
		this.taskID = taskID;
		
		setName(name);
		setDescription(description);
	}
	
	public String getTaskID() {
		return this.taskID;
	}
	
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.name = name;
		
	}
	
	public String getName() {
		return name;
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
