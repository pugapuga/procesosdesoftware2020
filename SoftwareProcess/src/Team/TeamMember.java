package Team;

import java.util.*;
import TaskBoard.*;

public class TeamMember {

	private String name;
	private Vector<Task> tasks;
	private Team team;

    public TeamMember(String name) {
        this.name = name;
    }
        
        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Vector<Task> tasks) {
        this.tasks = tasks;
    }
    
    

    @Override
    public String toString() {
        return "TeamMember{" + "name=" + name + '}';
    }
        
        

}