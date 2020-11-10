package edu.westga.cs.schoolgrades.views;

import javax.swing.table.AbstractTableModel;

import edu.westga.cs.schoolgrades.model.GradingStrategy;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;

/**
 * Implements the TableModel interface, using Grades as the rows
 * 
 * @author Greg Murrell
 * @version 11/10/2020
 */
public class GradeTableModel extends AbstractTableModel {
	private CompositeGrade gradesToWeigh;
	private WeightedGrade grade;
	
	public GradeTableModel(GradingStrategy strategy) {
		this(strategy, 0);
	}
	
	public GradeTableModel(GradingStrategy strategy, double weight) {
		this.gradesToWeigh = new CompositeGrade(strategy);
		this.grade = new WeightedGrade(this.gradesToWeigh, weight);
	}
	
	@Override
	public int getRowCount() {
		return this.gradesToWeigh.getListOfGrades().size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Double getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < 0) {
			throw new IndexOutOfBoundsException("TableModel cannot return a getValueAt for rowIndex less than zero");
		}
		return this.gradesToWeigh.getListOfGrades().get(rowIndex).getValue();
	}
	
	@Override
	public void setValueAt(Object value, int row, int column) {
		this.gradesToWeigh.addGrade(new SimpleGrade((Double) value), row);
		try {
			this.gradesToWeigh.removeGrade(row + 1);
		} catch (IndexOutOfBoundsException ex) {
			
		}
		this.fireTableDataChanged();
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}
	
	@Override
	public String getColumnName(int col) {
		return "Grades";
	}
	
	@Override
	public Class<Double> getColumnClass(int columnIndex) {
		return Double.class;
	}
	
	public void addRow() {
		this.setValueAt(0.00, this.getRowCount(), 1);
	}
	
	public GradingStrategy getGradingStrategy() {
		return this.gradesToWeigh.getGradingStrategy();
	}
	
	public void setGradingStrategy(GradingStrategy strategy) {
		this.gradesToWeigh.setGradingStrategy(strategy);
	}
	
	public void setWeight(double weight) {
		this.grade.setWeight(weight);
	}
	
	public double getTotalGrade() {
		return this.grade.getValue();
	}

}
