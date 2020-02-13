package TaskBoard;

public class Task {

    private String description;
    private TaskBoard taskBoard;
    private SwimLane swimLane;

    public Task(String description, TaskBoard taskBoard, SwimLane swimLane) {
        this.description = description;
        this.taskBoard = taskBoard;
        this.swimLane = swimLane;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskBoard getTaskBoard() {
        return taskBoard;
    }

    public void setTaskBoard(TaskBoard taskBoard) {
        this.taskBoard = taskBoard;
    }

    public SwimLane getSwimLane() {
        return swimLane;
    }

    public void setSwimLane(SwimLane swimLane) {
        this.swimLane = swimLane;
    }

    @Override
    public String toString() {
        return "Task{" + "description=" + description + '}';
    }
    
    

}
