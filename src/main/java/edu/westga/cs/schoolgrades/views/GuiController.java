package edu.westga.cs.schoolgrades.views;

import javax.swing.SpinnerNumberModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import edu.westga.cs.schoolgrades.model.DropLowestGradeGradingStrategy;
import edu.westga.cs.schoolgrades.model.AverageOfGradesGradingStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesGradingStrategy;

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
	
	private CompositeGrade finalGrade;
	
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
		
		this.tableQuizModel.addTableModelListener(e -> {
			this.updateQuizSubtotal();
		});
		this.tableHomeworkModel.addTableModelListener(e -> {
			this.updateHomeworkSubtotal();
		});
		this.tableExamModel.addTableModelListener(e -> {
			this.updateExamSubtotal();
		});
		
		this.finalGrade = new CompositeGrade(new SumOfGradesGradingStrategy());
		this.finalGrade.addGrade(this.tableQuizModel.getTotalGrade());
		this.finalGrade.addGrade(this.tableHomeworkModel.getTotalGrade());
		this.finalGrade.addGrade(this.tableExamModel.getTotalGrade());
		
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
	
	public void setQuizWeight() {
		this.tableQuizModel.setWeight(this.spinnerQuizWeightModel.getNumber().doubleValue());
		this.updateQuizSubtotal();
	}
	
	public void updateQuizSubtotal() {
		double subtotal = this.tableQuizModel.getTotalGrade();
		try {
			this.quizSubtotalModel.remove(0, this.quizSubtotalModel.getLength());
			this.quizSubtotalModel.insertString(0, String.format("%.2f", subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
		this.finalGrade.removeGrade(0);
		this.finalGrade.addGrade(subtotal, 0);
		this.updateFinalGrade();
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
	
	public void setHomeworkWeight() {
		this.tableHomeworkModel.setWeight(this.spinnerHomeworkWeightModel.getNumber().doubleValue());
		this.updateHomeworkSubtotal();
	}
	
	public void updateHomeworkSubtotal() {
		double subtotal = this.tableHomeworkModel.getTotalGrade();
		try {
			this.homeworkSubtotalModel.remove(0, this.homeworkSubtotalModel.getLength());
			this.homeworkSubtotalModel.insertString(0, String.format("%.2f", subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
		this.finalGrade.removeGrade(1);
		this.finalGrade.addGrade(subtotal, 1);
		this.updateFinalGrade();
	}
	
	public Document getExamSubtotalModel() {
		return this.examSubtotalModel;
	}
	
	public void setExamWeight() {
		this.tableExamModel.setWeight(this.spinnerExamWeightModel.getNumber().doubleValue());
		this.updateExamSubtotal();
	}
	
	public void updateExamSubtotal() {
		double subtotal = this.tableExamModel.getTotalGrade();
		try {
			this.examSubtotalModel.remove(0, this.examSubtotalModel.getLength());
			this.examSubtotalModel.insertString(0, String.format("%.2f", subtotal), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
		this.finalGrade.removeGrade(2);
		this.finalGrade.addGrade(subtotal, 2);
		this.updateFinalGrade();
	}
	
	public Document getFinalGradeModel() {
		return this.finalGradeModel;
	}
	
	public void updateFinalGrade() {
		double grade = this.finalGrade.getValue();
		try {
			this.finalGradeModel.remove(0, this.finalGradeModel.getLength());
			this.finalGradeModel.insertString(0, String.format("%.2f", grade), null);
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}	
	}
}
