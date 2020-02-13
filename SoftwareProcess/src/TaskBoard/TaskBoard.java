package TaskBoard;

import java.util.*;

public class TaskBoard {

    private String description;
    private Vector<Task> tasks = new Vector<Task>();
    private Vector<SwimLane> swimLanes = new Vector<SwimLane>();

    public TaskBoard(String description) {
        this.description = description;
        this.swimLanes.add(new SwimLane("Backlog", this));
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vector<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(Vector<Task> tasks) {
        this.tasks = tasks;
    }

    public Vector<SwimLane> getSwimLanes() {
        return this.swimLanes;
    }

    public void setSwimLanes(Vector<SwimLane> swimLanes) {
        this.swimLanes = swimLanes;
    }

    @Override
    public String toString() {
        return "TaskBoard{" + "description=" + description + ", tasks=" + tasks + ", swimLanes=" + swimLanes + '}';
    }
    

}
