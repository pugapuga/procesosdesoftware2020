/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareprocess;

import sim.engine.SimState;
import softwareprocess.model.Students;

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
        SimState state = new Students(System.currentTimeMillis());
        state.start();
        do {
            if (!state.schedule.step(state)) {
                break;
            }
        } while (state.schedule.getSteps() < 5000);
        state.finish();
        System.exit(0);

    }

}
