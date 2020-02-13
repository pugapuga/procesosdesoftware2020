/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareprocess;

import TaskBoard.Task;
import TaskBoard.TaskBoard;

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
        TaskBoard taskBoard = new TaskBoard("Mi tablero");
        
        Task task = new Task("Tarea", taskBoard, taskBoard.getSwimLanes().get(0));
        
        taskBoard.getTasks().add(task);

        
        System.out.println(taskBoard);
        
    }
    
}
