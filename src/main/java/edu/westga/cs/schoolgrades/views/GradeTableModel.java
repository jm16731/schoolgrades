package edu.westga.cs.schoolgrades.views;

import javax.swing.table.AbstractTableModel;

import edu.westga.cs.schoolgrades.model.GradingStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;

/**
 * Implements the TableModel interface, using Grades as the rows
 * 
 * @author Greg Murrell
 * @version 11/06/2020
 */
public class GradeTableModel extends AbstractTableModel {
	private CompositeGrade grade;
	
	public GradeTableModel() {
		this.grade = new CompositeGrade();
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
		this.grade.removeGrade(row);
		this.grade.addGrade((Grade) value, row);
		this.fireTableDataChanged();
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
	
	public void addRow() {
		this.grade.addGrade(0);
		this.fireTableDataChanged();
	}

}
