package Team;

import java.util.*;
import TaskBoard.*;
import sim.engine.SimState;
import sim.engine.Steppable;

public class TeamMember implements Steppable{

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

    @Override
    public void step(SimState ss) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        

}