/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareprocess;

import AgileTeam.AgileTeam;
import AgileTeam.Developer;
import AgileTeam.Sprint;
import AgileTeam.UserHistory;
import TaskBoard.Task;
import TaskBoard.TaskBoard;
import Team.Team;
import Team.TeamMember;

/**
 *
 * @author puga
 */
public class SoftwareProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AgileTeam agileTeam = new AgileTeam("T1");
        
        Developer developer = new Developer("Pepe");
        
        agileTeam.getTeamMembers().add(developer);
        
        Sprint sprint = new Sprint("Mi Sprint");
        
        UserHistory userHistory = new UserHistory("Historia", sprint, sprint.getSwimLanes().get(0),developer);
        
        sprint.getTasks().add(userHistory);

        
        System.out.println(sprint);
        
        System.out.println(agileTeam);
        
    }
    
}
