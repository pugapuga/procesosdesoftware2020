/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.process;

import Task_board.Board;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import sim.display.Console;
import sim.display.Controller;
import sim.display.Display2D;
import sim.display.GUIState;
import sim.engine.SimState;
import sim.portrayal.DrawInfo2D;
import sim.portrayal.Inspector;
import sim.portrayal.continuous.ContinuousPortrayal2D;
import sim.portrayal.network.NetworkPortrayal2D;
import sim.portrayal.network.SimpleEdgePortrayal2D;
import sim.portrayal.network.SpatialNetwork2D;
import sim.portrayal.simple.CircledPortrayal2D;
import sim.portrayal.simple.LabelledPortrayal2D;
import sim.portrayal.simple.MovablePortrayal2D;
import sim.portrayal.simple.OvalPortrayal2D;

/**
 *
 * @author puga
 */
public class CompanyGUI extends GUIState{

    
public Display2D display;
    public JFrame displayFrame;
    ContinuousPortrayal2D yardPortrayal = new ContinuousPortrayal2D();
    NetworkPortrayal2D buddiesPortrayal = new NetworkPortrayal2D();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CompanyGUI vid = new CompanyGUI();
        Console c = new Console(vid);
        c.setVisible(true);
    }

    public static Object getInfo() {
        try {
            return new java.net.URL("http://cyc.tij.uabc.mx/sim.html");
        } catch (java.net.MalformedURLException e) {
            return "Oops";
        }
    }

    public CompanyGUI() {
        super(new Project(System.currentTimeMillis()));
    }

    public CompanyGUI(SimState state) {
        super(state);
    }

    public static String getName() {
        return "Employees Company-yard Cliques";
    }

    @Override
    public Object getSimulationInspectedObject() {
        return state;
    }

    @Override
    public Inspector getInspector() {
        Inspector i = super.getInspector();
        i.setVolatile(true);
        return i;
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
        Project project = (Project) state;
        // tell the portrayals what to portray and how to portray them
        yardPortrayal.setField(project.yard);

        yardPortrayal.setPortrayalForAll(
                new MovablePortrayal2D(
                        new CircledPortrayal2D(
                                new LabelledPortrayal2D(
                                        new OvalPortrayal2D() {
                                    public void draw(Object object, Graphics2D graphics, DrawInfo2D info) {
                                        Employee employee = (Employee) object;
                                        int agitationShade = (int) (employee.getAgitation() * 255 / 10.0);
                                        if (agitationShade > 255) {
                                            agitationShade = 255;
                                        }
                                        paint = new Color(agitationShade, 0, 255 - agitationShade);
                                        super.draw(object, graphics, info);
                                    }
                                },
                                        5.0, null, Color.black, true),
                                0, 5.0, Color.green, true)));

        buddiesPortrayal.setField(new SpatialNetwork2D(project.yard, project.buddies));
        buddiesPortrayal.setPortrayalForAll(new SimpleEdgePortrayal2D());

        // reschedule the displayer
        display.reset();
        display.setBackdrop(Color.white);
        // redraw the display display.repaint();
    }

    @Override
    public void init(Controller c) {
        super.init(c);
        // make the displayer
        display = new Display2D(600, 600, this);
        // turn off clipping
        display.setClipping(false);

        displayFrame = display.createFrame();
        displayFrame.setTitle("Company-yard Display");
        c.registerFrame(displayFrame); // register the frame so it appears in the "Display" list displayFrame.setVisible(true);
        display.attach(buddiesPortrayal, "Buddies");
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
