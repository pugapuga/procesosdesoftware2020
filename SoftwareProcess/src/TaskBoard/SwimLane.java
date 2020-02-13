package TaskBoard;

import java.util.*;

public class SwimLane {

	private String description;
	private TaskBoard taskBoard;
	private Vector<Task> tasks = new Vector<Task>();;

    public SwimLane(String description, TaskBoard taskBoard) { 
        this.description = description;
        this.taskBoard = taskBoard;
    }
        
        

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskBoard getTaskBoard() {
		return this.taskBoard;
	}

	public void setTaskBoard(TaskBoard taskBoard) {
		this.taskBoard = taskBoard;
	}

	public Vector<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Vector<Task> tasks) {
		this.tasks = tasks;
	}

    @Override
    public String toString() {
        return "SwimLane{" + "description=" + description + '}';
    }
        
        

}