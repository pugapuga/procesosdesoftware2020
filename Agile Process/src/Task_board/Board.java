package Task_board;

import java.util.Vector;
import Task_board.SwimLane;
import Task_board.Issue;

public class Board {

    private String name;
    public Vector<SwimLane> swimLanes = new Vector<SwimLane>();
    public Vector<Issue> tasks = new Vector<Issue>();

    public Board(String name) {
        this.name = name;
    }

    public Vector<SwimLane> getSwimLanes() {
        return swimLanes;
    }

    public Vector<Issue> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void moveTask(SwimLane swimLaneOrigin, SwimLane swimLaneTarget, Issue task){
        swimLaneTarget.getTasks().add(task);
        swimLaneOrigin.getTasks().remove(task);
    }
    
    public void moveTask(String swimLaneOrigin, String swimLaneTarget, String task){
        //swimLaneTarget.getTasks().add(task);
        //swimLaneOrigin.getTasks().remove(task);
    }

    @Override
    public String toString() {
        return "Board{" + "name=" + name + ", swimLanes=" + swimLanes + ", tasks=" + tasks + '}';
    }

}
