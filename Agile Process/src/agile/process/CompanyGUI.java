/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.process;

import Task_board.Board;
import sim.display.GUIState;
import sim.engine.SimState;

/**
 *
 * @author puga
 */
public class CompanyGUI extends GUIState{
    Board board = new Board("My board");
    
    public CompanyGUI(SimState state) {
        super(state);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
}
