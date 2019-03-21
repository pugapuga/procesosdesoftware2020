package Task_board;

import java.util.Vector;
import Task_board.Issue;

public class SwimLane {
	private String name;
	private Board board;
	private Vector<Issue> tasks = new Vector<Issue>();

    public SwimLane(String name, Board board) {
        this.name = name;
        this.board = board;
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "SwimLane{" + "name=" + name + ", tasks=" + tasks + '}';
    }


    
}