package AgileTeam;

import TaskBoard.*;
import Team.TeamMember;

public class UserHistory extends Task {

    public UserHistory(String description, TaskBoard taskBoard, SwimLane swimLane, TeamMember teamMember) {
        super(description, taskBoard, swimLane, teamMember);
    }

    public UserHistory(String description, TaskBoard taskBoard, SwimLane swimLane) {
        super(description, taskBoard, swimLane);
    }
    
}