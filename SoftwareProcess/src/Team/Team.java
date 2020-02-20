package Team;

import java.util.*;

public class Team {

	private Vector<TeamMember> teamMembers;
	private String descripcion;

    public Team(String descripcion) {
        this.descripcion = descripcion;
        this.teamMembers = new Vector<TeamMember>();
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
        
        

}