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
		
		this.spinnerQuizWeight.setModel(this.controller.getSpinnerQuizWeightModel());
		this.spinnerHomeworkWeight.setModel(this.controller.getSpinnerHomeworkWeightModel());
		this.spinnerExamWeight.setModel(this.controller.getSpinnerExamWeightModel());
		
		this.textFieldQuizSubtotal.setDocument(this.controller.getQuizSubtotalModel());
		this.textFieldHomeworkSubtotal.setDocument(this.controller.getHomeworkSubtotalModel());
		this.textFieldExamSubtotal.setDocument(this.controller.getExamSubtotalModel());
		this.textFieldFinalGrade.setDocument(this.controller.getFinalGradeModel());

		this.setMouseListeners();
		this.setActionListeners();
	}
	
	private void setMouseListeners() {
		
	}
	
	private void setActionListeners() {
		
	}
}
