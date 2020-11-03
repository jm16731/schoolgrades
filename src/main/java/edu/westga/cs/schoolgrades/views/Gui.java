package edu.westga.cs.schoolgrades.views;

/**
 * User configuration of the GUI
 * 
 * @author Greg Murrell
 * @version 11/03/2020
 */
public class Gui extends GuiWindowBuilderLayout {
	private GuiController controller;
	
	public Gui() {
		this.controller = new GuiController();
		
		this.tableQuiz.setModel(this.controller.getTableQuizModel());
		this.tableHomework.setModel(this.controller.getTableHomeworkModel());
		this.tableExam.setModel(this.controller.getTableExamModel());

		this.setMouseListeners();
		this.setActionListeners();
	}
	
	private void setMouseListeners() {
		
	}
	
	private void setActionListeners() {
		
	}
}
