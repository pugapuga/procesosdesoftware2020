/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Team;

import sim.portrayal.continuous.*;
import sim.engine.*;
import sim.display.*;
import javax.swing.*;


public class TeamWithUI extends GUIState {

    public Display2D display;
    public JFrame displayFrame;
    ContinuousPortrayal2D yardPortrayal = new ContinuousPortrayal2D();

    public static void main(String[] args) {
        TeamWithUI vid = new TeamWithUI();
        Console c = new Console(vid);
        c.setVisible(true);
    }

    public TeamWithUI() {
        super(new Team(System.currentTimeMillis()));
    }

    public TeamWithUI(SimState state) {
        super(state);
    }

    public static String getName() {
        return "Team Members Projectyard Cliques";
    }

    @Override
    public void start() {
        super.start();
        setupPortrayals();
    }

    @Override
    public void load(SimState state) {
        super.load(state);
        setupPortrayals();
    }

    public void setupPortrayals() {
        Team team = (Team) state;
// tell the portrayals what to portray and how to portray them yardPortrayal.setField( students.yard ); yardPortrayal.setPortrayalForAll(new OvalPortrayal2D());
// reschedule the displayer display.reset(); display.setBackdrop(Color.white);
// redraw the display display.repaint();
    }

    @Override
    public void init(Controller c) {
        super.init(c);
        display = new Display2D(600, 600, this);
        display.setClipping(false);
        displayFrame = display.createFrame();
        displayFrame.setTitle("Projectyard Display");
        c.registerFrame(displayFrame); // so the frame appears in the "Display" list displayFrame.setVisible(true);
        display.attach(yardPortrayal, "Yard");
    }

    @Override
    public void quit() {
        super.quit();
        if (displayFrame != null) {
            displayFrame.dispose();
        }
        displayFrame = null;
        display = null;
    }
}

