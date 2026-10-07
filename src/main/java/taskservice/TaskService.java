package taskservice;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();
	
	public void addTask(Task task) {	
	
		if (tasks.containsKey(task.getTaskID())) {
			throw new IllegalArgumentException("Already a task with that ID.");
		}
		tasks.put(task.getTaskID(), task);
	}
	
	public void deleteTask(String taskID) {
		if (!tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("taskID doesn't exist.");
		}
		tasks.remove(taskID);
	}
	
	public void updateName(String taskID, String name) {
		getTask(taskID).setName(name);
	}
	
	public void updateDescription(String taskID, String description) {
		getTask(taskID).setDescription(description);
	}
	
	public Task getTask(String taskID) {
		Task task = tasks.get(taskID);
		if (task == null) {
			throw new IllegalArgumentException("Invalid task ID. No task with that ID has been created.");
		}
		return task;
	}
}
