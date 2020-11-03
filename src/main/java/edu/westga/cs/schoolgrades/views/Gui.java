package edu.westga.cs.schoolgrades.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.westga.cs.schoolgrades.model.SimpleGrade;

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
		this.btnAddQuiz.addActionListener(e -> {
			Gui.this.controller.getTableQuizModel().addRow();
		});
		this.btnAddHomework.addActionListener(e -> {
			Gui.this.controller.getTableHomeworkModel().addRow();
		});
		this.btnAddExam.addActionListener(e -> {
			Gui.this.controller.getTableExamModel().addRow();
		});
	}
}
