/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.process;

import Task_board.Board;
import Task_board.Issue;
import Task_board.SwimLane;
import Task_board.Task;
import sim.engine.SimState;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.field.network.Edge;
import sim.util.Bag;
import sim.util.Double2D;
import sim.util.MutableDouble2D;

/**
 *
 * @author puga
 */
public class Employee implements Steppable{
    Board board = null;
    
    
    public static final double MAX_FORCE = 3.0;

    double friendsClose = 0.0; // initially very close to my friends 
    double enemiesCloser = 10.0; // WAY too close to my enemies

    Employee(Board board) {
        this.board = board;
    }

    public double getAgitation() {
        return friendsClose + enemiesCloser;
    }

    @Override
    public String toString() {
        return "[" + System.identityHashCode(this) + "] agitation: " + getAgitation();
    }

    @Override
    public void step(SimState state) {
        Project project = (Project) state;
        Continuous2D yard = project.yard;
        Double2D me = project.yard.getObjectLocation(this);
        MutableDouble2D sumForces = new MutableDouble2D();

        friendsClose = enemiesCloser = 0.0;
        
        //Nuestro codigo de experimento
        SwimLane swimLaneBacklog = board.getSwimLanes().get(0);
        SwimLane swimLaneToDo = board.getSwimLanes().get(1);
        SwimLane swimLaneDone = board.getSwimLanes().get(2);
                
        if (!swimLaneBacklog.getTasks().isEmpty()){
        Issue issue = swimLaneBacklog.getTasks().get(0);
        board.moveTask(swimLaneBacklog, swimLaneToDo, issue);
        System.out.println(board);
        board.moveTask(swimLaneToDo, swimLaneDone, issue);
        System.out.println(board);
        }

        // Go through my buddies and determine how much I want to be near them
        MutableDouble2D forceVector = new MutableDouble2D();
        Bag out = project.buddies.getEdges(this, null);
        int len = out.size();
        for (int buddy = 0; buddy < len; buddy++) {
            Edge e = (Edge) (out.get(buddy));
            double buddiness = ((Double) (e.info)).doubleValue();
            // I could be in the to() end or the from() end.  getOtherNode is a cute function
            // which grabs the guy at the opposite end from me.
            Double2D him = project.yard.getObjectLocation(e.getOtherNode(this));
            if (buddiness >= 0) // the further I am from him the more I want to go to him
            {
                forceVector.setTo((him.x - me.x) * buddiness, (him.y - me.y) * buddiness);
                if (forceVector.length() > MAX_FORCE) // I’m far enough away
                {
                    forceVector.resize(MAX_FORCE);
                }
                friendsClose += forceVector.length();
            } else // the nearer I am to him the more I want to get away from him, up to a limit
            {
                forceVector.setTo((him.x - me.x) * buddiness, (him.y - me.y) * buddiness);
                if (forceVector.length() > MAX_FORCE) // I’m far enough away
                {
                    forceVector.resize(0.0);
                } else if (forceVector.length() > 0) {
                    forceVector.resize(MAX_FORCE - forceVector.length());  // invert the distance
                }
                enemiesCloser += forceVector.length();
            }
            sumForces.addIn(forceVector);
        }
        // add in a vector to the "teacher" -- the center of the yard, so we don’t go too far away
        sumForces.addIn(new Double2D((yard.width * 0.5 - me.x) * project.forceToSchoolMultiplier,
                (yard.height * 0.5 - me.y) * project.forceToSchoolMultiplier));
        // add a bit of randomness
        sumForces.addIn(new Double2D(project.randomMultiplier * (project.random.nextDouble() * 1.0 - 0.5),
                project.randomMultiplier * (project.random.nextDouble() * 1.0 - 0.5)));
        sumForces.addIn(me);
        project.yard.setObjectLocation(this, new Double2D(sumForces));

    }   
}
