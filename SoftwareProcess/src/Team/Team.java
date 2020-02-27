package Team;

import java.util.*;
import sim.engine.SimState;
import static sim.engine.SimState.doLoop;
import sim.field.continuous.Continuous2D;
import sim.util.Double2D;


public class Team extends SimState {
    
    public Continuous2D yard = new Continuous2D(1.0, 100, 100);
    public int numTeamMembers = 10;
    double forceToSchoolMultiplier = 0.01;
    double randomMultiplier = 0.1;

    private Vector<TeamMember> teamMembers;
    private String descripcion;

    public Team(long seed) {
        super(seed);
        
        teamMembers.add(new TeamMember("pepe"));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vector<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Vector<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "Team{" + "teamMembers=" + teamMembers + ", descripcion=" + descripcion + '}';
    }
    
        public void start() {
        super.start();
// clear the yard yard.clear();
// clear the buddies buddies.clear();
        // add some students to the yard
        for (int i = 0; i < numTeamMembers; i++) {
            yard.setObjectLocation(teamMembers.get(i),new Double2D(yard.getWidth() * 0.5 + random.nextDouble() - 0.5, yard.getHeight() * 0.5 + random.nextDouble() - 0.5));
            schedule.scheduleRepeating(teamMembers.get(i));
        }
    }

    public static void main(String[] args) {
        doLoop(Team.class, args);
        System.exit(0);
    }

}
