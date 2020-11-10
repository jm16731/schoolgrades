package edu.westga.cs.schoolgrades.views;

import javax.swing.SpinnerNumberModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import edu.westga.cs.schoolgrades.model.DropLowestGradeGradingStrategy;
import edu.westga.cs.schoolgrades.model.AverageOfGradesGradingStrategy;
import edu.westga.cs.schoolgrades.model.SumOfGradesGradingStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

/**
 * Creates the model objects for the GUI
 * 
 * @author Greg Murrell
 * @version 11/10/2020
 */
public class GuiController {
	private GradeTableModel tableQuizModel;
	private GradeTableModel tableHomeworkModel;
	private GradeTableModel tableExamModel;
	private GradeTableModel tableFinalGradeModel;
	
	private SpinnerNumberModel spinnerQuizWeightModel;
	private SpinnerNumberModel spinnerHomeworkWeightModel;
	private SpinnerNumberModel spinnerExamWeightModel;
	
	private Document quizSubtotalModel;
	private Document homeworkSubtotalModel;
	private Document examSubtotalModel;
	private Document finalGradeModel;
	
	GuiController() {
		this.tableQuizModel = new GradeTableModel(new AverageOfGradesGradingStrategy());
		this.tableHomeworkModel = new GradeTableModel(new AverageOfGradesGradingStrategy());
		this.tableExamModel = new GradeTableModel(new AverageOfGradesGradingStrategy());
		this.tableFinalGradeModel = new GradeTableModel(new SumOfGradesGradingStrategy());
		
		this.tableFinalGradeModel.addRow();
		this.tableFinalGradeModel.addRow();
		this.tableFinalGradeModel.addRow();
		
		this.tableQuizModel.addTableModelListener(e -> {
			this.updateQuizSubtotal();
		});
		this.tableHomeworkModel.addTableModelListener(e -> {
			this.updateHomeworkSubtotal();
		});
		this.tableExamModel.addTableModelListener(e -> {
			this.updateExamSubtotal();
		});
		this.tableFinalGradeModel.addTableModelListener(e -> {
			this.updateFinalGrade();
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
	
	public void updateQuizSubtotal() {
		WeightedGrade grade = new WeightedGrade(
				this.tableQuizModel.getGrade(), this.spinnerQuizWeightModel.getNumber().doubleValue());
			double subtotal = grade.getValue();
		try {
			this.quizSubtotalModel.remove(0, this.quizSubtotalModel.getLength());
			this.quizSubtotalModel.insertString(0, String.valueOf(subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
		this.tableFinalGradeModel.setValueAt(subtotal, 1, 1);
	}
	
	public Document getHomeworkSubtotalModel() {
		return this.homeworkSubtotalModel;
	}
	
	public void shouldDropLowestHomeworkGrade(boolean drop) {
		if (drop) {
			this.tableHomeworkModel.setGradingStrategy(
				new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy()));
		} else {
			this.tableHomeworkModel.setGradingStrategy(
				new AverageOfGradesGradingStrategy());
		}
		this.updateHomeworkSubtotal();
	}
	
	public void updateHomeworkSubtotal() {
		WeightedGrade grade = new WeightedGrade(
				this.tableHomeworkModel.getGrade(), this.spinnerHomeworkWeightModel.getNumber().doubleValue());
			double subtotal = grade.getValue();
		try {
			this.homeworkSubtotalModel.remove(0, this.homeworkSubtotalModel.getLength());
			this.homeworkSubtotalModel.insertString(0, String.valueOf(subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
		this.tableFinalGradeModel.setValueAt(subtotal, 2, 1);
	}
	
	public Document getExamSubtotalModel() {
		return this.examSubtotalModel;
	}
	
	public void updateExamSubtotal() {
		WeightedGrade grade = new WeightedGrade(
			this.tableExamModel.getGrade(), this.spinnerExamWeightModel.getNumber().doubleValue());
		double subtotal = grade.getValue();
		try {
			this.examSubtotalModel.remove(0, this.examSubtotalModel.getLength());
			this.examSubtotalModel.insertString(0, String.valueOf(subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
		this.tableFinalGradeModel.setValueAt(subtotal, 3, 1);
	}
	
	public Document getFinalGradeModel() {
		return this.finalGradeModel;
	}
	
	public void updateFinalGrade() {
		double subtotal = this.tableFinalGradeModel.getTotalGrade();
		try {
			this.finalGradeModel.remove(0, this.finalGradeModel.getLength());
			this.finalGradeModel.insertString(0, String.valueOf(subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}	
	}
}
