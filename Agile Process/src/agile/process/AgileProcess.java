/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.process;

import Task_board.Board;
import Task_board.SwimLane;
import Task_board.Task;

/**
 *
 * @author puga
 */
public class AgileProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Board myBoard = new Board("Scrum");
        System.out.println(myBoard);
        
        SwimLane swimLane1 = new SwimLane("Backlog", myBoard);
        myBoard.swimLanes.add(swimLane1);
        
        System.out.println(myBoard);
        
        SwimLane swimLane2 = new SwimLane("ToDo", myBoard);
        myBoard.swimLanes.add(swimLane2);
        
        System.out.println(myBoard);
        
        Task task1 = new Task("T1","Tarea 1", "Descripcion", myBoard, swimLane1);
        swimLane1.getTasks().add(task1);
        
        System.out.println(myBoard);
        
        myBoard.moveTask(swimLane1, swimLane2, task1);
        
        System.out.println(myBoard);
    }
    
}
