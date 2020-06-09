package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * <h2>A class to control the GUI of the Sudoku solver.</h2>
 * <hr>
 * @author Josh Graham
 * @version 1.0
 */
public class SudokuController {
	// Creating instances of each GUI Object	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField pos0, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8,
	  				  pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17,
	  				  pos18, pos19, pos20, pos21, pos22, pos23, pos24, pos25, pos26,
	  				  pos27, pos28, pos29, pos30, pos31, pos32, pos33, pos34, pos35,
	  				  pos36, pos37, pos38, pos39, pos40, pos41, pos42, pos43, pos44,
	  				  pos45, pos46, pos47, pos48, pos49, pos50, pos51, pos52, pos53,
	  				  pos54, pos55, pos56, pos57, pos58, pos59, pos60, pos61, pos62,
	  				  pos63, pos64, pos65, pos66, pos67, pos68, pos69, pos70, pos71,
	  				  pos72, pos73, pos74, pos75, pos76, pos77, pos78, pos79, pos80;
    @FXML
    private Button btnSolve;
    // initializes 2d array of text fields
    private TextField[][] textFields;
    
    /**
     * <h2>A method that is triggered when the "solve" button is clicked.</h2>
     * 
     * <p>The numbers entered by the user on the grid are taken and added to the board attribute
     * of the Sudoku object. The Sudoku game is solved, and then the numbers are added back to the 
     * GUI grid.</p>
     * @param event The action of the mouse clicking.
     */
    @FXML
    void btnOnClick(ActionEvent event) {
    	// Loops through each text field and saves each entered number to the 2d board array
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(!textFields[i][j].getText().equals("")) 
    				board.setNumber(i, j, Integer.parseInt(textFields[i][j].getText()));   			
    		}
    	}
    	board.solveBoard(0, 0); // Solves the sudoku game, will always start at (0,0)
    	// Loops through every text field, filling in the solved values
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(textFields[i][j].getText().equals("")) {
    				String solveNum = Integer.toString(board.getNumber(i, j)); // Converts int to string
    				textFields[i][j].setText(solveNum); // Places the solved number in it's square
    				textFields[i][j].setStyle("-fx-text-inner-color: red;"); // Changes solved number to red
    			}
    		}
    	}
    } // End btnOnClick method
    
    // Creates an empty Sudoku board
    Sudoku board = new Sudoku();
      
    @FXML
    void initialize() {
    	// Creating an array of text fields with the same structure as the 2d board array
    	textFields = new TextField[][] {{pos0, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8},
    								  {pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17},
    								  {pos18, pos19, pos20, pos21, pos22, pos23, pos24, pos25, pos26},
    								  {pos27, pos28, pos29, pos30, pos31, pos32, pos33, pos34, pos35},
    								  {pos36, pos37, pos38, pos39, pos40, pos41, pos42, pos43, pos44},
    								  {pos45, pos46, pos47, pos48, pos49, pos50, pos51, pos52, pos53},
    								  {pos54, pos55, pos56, pos57, pos58, pos59, pos60, pos61, pos62},
    								  {pos63, pos64, pos65, pos66, pos67, pos68, pos69, pos70, pos71},
    								  {pos72, pos73, pos74, pos75, pos76, pos77, pos78, pos79, pos80}};
    	    	
    } // end initialize method
} // End SudokuController class
