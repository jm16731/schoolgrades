package edu.westga.cs.schoolgrades.views;

import javax.swing.table.AbstractTableModel;

import edu.westga.cs.schoolgrades.model.AverageOfGradesGradingStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;

/**
 * Implements the TableModel interface, using Grades as the rows
 * 
 * @author Greg Murrell
 * @version 11/03/2020
 */
public class GradeTableModel extends AbstractTableModel {
	private CompositeGrade grade;
	
	public GradeTableModel() {
		this.grade = new CompositeGrade(new AverageOfGradesGradingStrategy());
	}
	
	@Override
	public int getRowCount() {
		//TODO: CompositeGrade should calculate size itself; needs Tests though
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
		//TODO: still looks ugly
		return this.grade.getListOfGrades().get(rowIndex);
	}
	
	public void addRow(Grade grade) {
		this.grade.addGrade(grade);
	}

}
