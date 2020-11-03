package edu.westga.cs.schoolgrades.views;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 * Creates the model objects for the GUI
 * 
 * @author Greg Murrell
 * @version 11/03/2020
 */
public class GuiController {
	private DefaultTableModel tableQuizModel;
	private DefaultTableModel tableHomeworkModel;
	private DefaultTableModel tableExamModel;
	
	private SpinnerNumberModel spinnerQuizWeightModel;
	private SpinnerNumberModel spinnerHomeworkWeightModel;
	private SpinnerNumberModel spinnerExamWeightModel;
	
	GuiController() {
		this.tableQuizModel = new DefaultTableModel();
		this.tableHomeworkModel = new DefaultTableModel();
		this.tableExamModel = new DefaultTableModel();
		
		this.spinnerQuizWeightModel = new SpinnerNumberModel();
		this.spinnerHomeworkWeightModel = new SpinnerNumberModel();
		this.spinnerExamWeightModel = new SpinnerNumberModel();
	}
	
	public DefaultTableModel getTableQuizModel() {
		return this.tableQuizModel;
	}
	
	public DefaultTableModel getTableHomeworkModel() {
		return this.tableHomeworkModel;
	}
	
	public DefaultTableModel getTableExamModel() {
		return this.tableExamModel;
	}
	
	public SpinnerNumberModel getSpinnerQuizWeightModel() {
		return this.spinnerQuizWeightModel;
	}
	
	public SpinnerNumberModel getSpinnerHomeworkWeightModel() {
		return this.spinnerHomeworkWeightModel;
	}
	
	public SpinnerNumberModel getSpinnerExamWeightModel() {
		return this.spinnerExamWeightModel;
	}

	/**
	 * any mouse listeners
	 */
	
	/**
	 * any action (button) listeners
	 */
}
