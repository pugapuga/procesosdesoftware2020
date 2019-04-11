/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.process;

import Task_board.Board;
import Task_board.Issue;
import Task_board.SwimLane;
import sim.engine.SimState;
import static sim.engine.SimState.doLoop;
import sim.engine.Steppable;
import sim.field.continuous.Continuous2D;
import sim.field.network.Network;
import sim.util.Bag;
import sim.util.Double2D;

/**
 *
 * @author puga
 */
public class Project extends SimState{
    Board board = new Board("My board");
    
    public Continuous2D yard = new Continuous2D(1.0, 100, 100);

    public double TEMPERING_CUT_DOWN = 0.99;
    public double TEMPERING_INITIAL_RANDOM_MULTIPLIER = 10.0;
    public boolean tempering = true;

        public Project(long seed) {
        super(seed);
        
        System.out.println(board);
        
        SwimLane swimLaneBacklog = new SwimLane("Backlog", board);
        board.swimLanes.add(swimLaneBacklog);
        
        System.out.println(board);
        
        SwimLane swimLaneToDo = new SwimLane("ToDo", board);
        board.swimLanes.add(swimLaneToDo);
        
        System.out.println(board);
        
        SwimLane swimLaneDone = new SwimLane("Done", board);
        board.swimLanes.add(swimLaneDone);
        
        System.out.println(board);
        
        Issue task1 = new Issue("T1","Tarea 1", "Descripcion", board, swimLaneBacklog);
        swimLaneBacklog.getTasks().add(task1);
        board.getTasks().add(task1);
        
        System.out.println(board);
        
    }
    
    

    public boolean isTempering() {
        return tempering;
    }

    public void setTempering(boolean val) {
        tempering = val;
    }

    public int numEmployees = 10;
    double forceToSchoolMultiplier = 0.01;
    double randomMultiplier = 0.1;

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int val) {
        if (val > 0) {
            numEmployees = val;
        }
    }

    public double getForceToCompanyMultiplier() {
        return forceToSchoolMultiplier;
    }

    public void setForceToCompanyMultiplier(double val) {
        if (forceToSchoolMultiplier >= 0.0) {
            forceToSchoolMultiplier = val;
        }
    }

    public double getRandomMultiplier() {
        return randomMultiplier;
    }

    public void setRandomMultiplier(double val) {
        if (randomMultiplier >= 0.0) {
            randomMultiplier = val;
        }
    }

    public Object domRandomMultiplier() {
        return new sim.util.Interval(0.0, 100.0);
    }

    public double[] getAgitationDistribution() {
        Bag employees = buddies.getAllNodes();
        double[] distro = new double[employees.numObjs];
        for (int i = 0; i < employees.numObjs; i++) {
            distro[i] = ((Employee) (employees.objs[i])).getAgitation();
        }
        return distro;
    }

    public Network buddies = new Network(false);



    @Override
    public void start() {
        super.start();
        
        // add the tempering agent
        if (tempering) {
            randomMultiplier = TEMPERING_INITIAL_RANDOM_MULTIPLIER;
            schedule.scheduleRepeating(schedule.EPOCH, 1, new Steppable() {
                @Override
                public void step(SimState state) {
                    if (tempering) {
                        randomMultiplier *= TEMPERING_CUT_DOWN;
                    }
                }
            });
        }
        
        // clear the yard
        yard.clear();
        // clear the buddies
        //buddies.clear();
        // add some employees to the yard
        for (int i = 0; i < numEmployees; i++) {
            Employee employee = new Employee(board);
            yard.setObjectLocation(employee,
                    new Double2D(yard.getWidth() * 0.5 + random.nextDouble() - 0.5,
                            yard.getHeight() * 0.5 + random.nextDouble() - 0.5));

            buddies.addNode(employee);
            schedule.scheduleRepeating(employee);
        }

        // define like/dislike relationships
        Bag employees = buddies.getAllNodes();
        for (int i = 0; i < employees.size(); i++) {
            Object employee = employees.get(i);
            // who does he like?
            Object employeeB = null;
            do {
                employeeB = employees.get(random.nextInt(employees.numObjs));
            } while (employee == employeeB);
            double buddiness = random.nextDouble();
            buddies.addEdge(employee, employeeB, new Double(buddiness));
            // who does he dislike?
            do {
                employeeB = employees.get(random.nextInt(employees.numObjs));
            } while (employee == employeeB);
            buddiness = random.nextDouble();
            buddies.addEdge(employee, employeeB, new Double(-buddiness));
        }

    }

    public static void main(String[] args) {
        doLoop(Project.class, args);
        System.exit(0);
    }
    
}
