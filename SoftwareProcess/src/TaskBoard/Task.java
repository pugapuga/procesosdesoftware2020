package TaskBoard;

import Team.*;

public class Task {

    private String description;
    private TaskBoard taskBoard;
    private SwimLane swimLane;
	private TeamMember teamMember;

    public Task(String description, TaskBoard taskBoard, SwimLane swimLane, TeamMember teamMember) {
        this.description = description;
        this.taskBoard = taskBoard;
        this.swimLane = swimLane;
        this.teamMember = teamMember;
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

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
    
    

    @Override
    public String toString() {
        return "Task{" + "description=" + description + '}';
    }

	/**
	 * 
	 * @param description
	 * @param taskBoard
	 * @param swimLane
	 */
	public Task(String description, TaskBoard taskBoard, SwimLane swimLane) {
		// TODO - implement Task.Task
		throw new UnsupportedOperationException();
	}
    
    

}
