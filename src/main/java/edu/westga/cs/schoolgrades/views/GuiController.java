package edu.westga.cs.schoolgrades.views;

import javax.swing.SpinnerNumberModel;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import edu.westga.cs.schoolgrades.model.Grade;

/**
 * Creates the model objects for the GUI
 * 
 * @author Greg Murrell
 * @version 11/03/2020
 */
public class GuiController {
	private GradeTableModel tableQuizModel;
	private GradeTableModel tableHomeworkModel;
	private GradeTableModel tableExamModel;
	
	private SpinnerNumberModel spinnerQuizWeightModel;
	private SpinnerNumberModel spinnerHomeworkWeightModel;
	private SpinnerNumberModel spinnerExamWeightModel;
	
	private Document quizSubtotalModel;
	private Document homeworkSubtotalModel;
	private Document examSubtotalModel;
	private Document finalGradeModel;
	
	GuiController() {
		this.tableQuizModel = new GradeTableModel();
		this.tableHomeworkModel = new GradeTableModel();
		this.tableExamModel = new GradeTableModel();
		
		this.tableQuizModel.addTableModelListener(e -> {
			/**
			 * 		int row = e.getFirstRow();
					int type = e.getType();
					GradeTableModel model = (GradeTableModel) e.getSource();
					Grade data = (Grade) model.getValueAt(row, 1);
			 */
		});
		this.tableHomeworkModel.addTableModelListener(e -> {
			
		});
		this.tableExamModel.addTableModelListener(e -> {
			
		});
		
		this.spinnerQuizWeightModel = new SpinnerNumberModel(0.00, 0, 1, 0.01);
		this.spinnerHomeworkWeightModel = new SpinnerNumberModel(0.00, 0, 1, 0.01);
		this.spinnerExamWeightModel = new SpinnerNumberModel(0.00, 0, 1, 0.01);
		
		this.quizSubtotalModel = new PlainDocument();
		this.homeworkSubtotalModel = new PlainDocument();
		this.examSubtotalModel = new PlainDocument();
		this.finalGradeModel = new PlainDocument();
	}
	
	public GradeTableModel getTableQuizModel() {
		return this.tableQuizModel;
	}
	
	public void addQuiz() {
		this.tableQuizModel.addRow();
	}
	
	public GradeTableModel getTableHomeworkModel() {
		return this.tableHomeworkModel;
	}
	
	public void addHomework() {
		this.tableHomeworkModel.addRow();
	}
	
	public GradeTableModel getTableExamModel() {
		return this.tableExamModel;
	}
	
	public void addExam() {
		this.tableExamModel.addRow();
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
}
