package Task_board;

import java.util.*;

public class Task extends Issue {

    private Vector<SubTask> subTasks = new Vector<SubTask>();

    public Task(String id, String subject, String description, Board board, SwimLane swimLane) {
        super(id, subject, description, board, swimLane);
    }

    public Vector<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(Vector<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public String toString() {
        return "Task{" + "subTasks=" + subTasks + '}';
    }
    
}