package edu.westga.cs.schoolgrades.views;

import javax.swing.table.AbstractTableModel;

import edu.westga.cs.schoolgrades.model.GradingStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;

/**
 * Implements the TableModel interface, using Grades as the rows
 * 
 * @author Greg Murrell
 * @version 11/10/2020
 */
public class GradeTableModel extends AbstractTableModel {
	private CompositeGrade grade;
	
	public GradeTableModel(GradingStrategy strategy) {
		this.grade = new CompositeGrade(strategy);
	}
	
	@Override
	public int getRowCount() {
		return this.grade.getListOfGrades().size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Grade getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < 0) {
			throw new IndexOutOfBoundsException("TableModel cannot return a getValueAt for rowIndex less than zero");
		}
		return this.grade.getListOfGrades().get(rowIndex);
	}
	
	@Override
	public void setValueAt(Object value, int row, int column) {
		this.grade.addGrade((SimpleGrade) value, row);
		try {
			this.grade.removeGrade(row + 1);
		} catch (IndexOutOfBoundsException ex) {
			
		}
		this.fireTableDataChanged();
	}
	
	public void setValueAt(double value, int row, int column) {
		this.setValueAt(new SimpleGrade(value), row, column);
	}
	
	public void addRow() {
		this.setValueAt(0, this.getRowCount(), 1);
	}
	
	public GradingStrategy getGradingStrategy() {
		return this.grade.getGradingStrategy();
	}
	
	public void setGradingStrategy(GradingStrategy strategy) {
		this.grade.setGradingStrategy(strategy);
	}
	
	public double getTotalGrade() {
		return this.grade.getValue();
	}
	
	public CompositeGrade getGrade() {
		return this.grade;
	}

}
