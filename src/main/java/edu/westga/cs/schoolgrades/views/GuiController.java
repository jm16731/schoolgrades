package edu.westga.cs.schoolgrades.views;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Creates the model objects for the GUI
 * 
 * @author Greg Murrell
 * @version 11/03/2020
 */
public class GuiController {
	private TableModel tableQuizModel;
	private TableModel tableHomeworkModel;
	private TableModel tableExamModel;
	
	private SpinnerNumberModel spinnerQuizWeightModel;
	private SpinnerNumberModel spinnerHomeworkWeightModel;
	private SpinnerNumberModel spinnerExamWeightModel;
	
	private Document quizSubtotalModel;
	private Document homeworkSubtotalModel;
	private Document examSubtotalModel;
	private Document finalGradeModel;
	
	GuiController() {
		this.tableQuizModel = new DefaultTableModel();
		this.tableHomeworkModel = new DefaultTableModel();
		this.tableExamModel = new DefaultTableModel();
		
		this.spinnerQuizWeightModel = new SpinnerNumberModel();
		this.spinnerHomeworkWeightModel = new SpinnerNumberModel();
		this.spinnerExamWeightModel = new SpinnerNumberModel();
		
		this.quizSubtotalModel = new PlainDocument();
		this.homeworkSubtotalModel = new PlainDocument();
		this.examSubtotalModel = new PlainDocument();
		this.finalGradeModel = new PlainDocument();
	}
	
	public TableModel getTableQuizModel() {
		return this.tableQuizModel;
	}
	
	public TableModel getTableHomeworkModel() {
		return this.tableHomeworkModel;
	}
	
	public TableModel getTableExamModel() {
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
	
	public Document getQuizSubtotalModel() {
		return this.quizSubtotalModel;
	}
	
	public Document getHomeworkSubtotalModel() {
		return this.homeworkSubtotalModel;
	}
	
	public Document getExamSubtotalModel() {
		return this.examSubtotalModel;
	}
	
	public Document getFinalGradeModel() {
		return this.finalGradeModel;
	}

	/**
	 * any mouse listeners
	 */
	
	/**
	 * any action (button) listeners
	 */
}
