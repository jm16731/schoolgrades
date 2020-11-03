package edu.westga.cs.schoolgrades.views;

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
	
	GuiController() {
		this.tableQuizModel = new DefaultTableModel();
		this.tableHomeworkModel = new DefaultTableModel();
		this.tableExamModel = new DefaultTableModel();
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

	/**
	 * any mouse listeners
	 */
	
	/**
	 * any action (button) listeners
	 */
}
