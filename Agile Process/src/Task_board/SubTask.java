package Task_board;

public class SubTask extends Issue {

	Task task;

    public SubTask(String id, String subject, String description, Board board, SwimLane swimLane) {
        super(id, subject, description, board, swimLane);
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "SubTask{" + "task=" + task + '}';
    }
    
    

}