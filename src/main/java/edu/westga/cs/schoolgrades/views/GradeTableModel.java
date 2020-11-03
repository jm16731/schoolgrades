package edu.westga.cs.schoolgrades.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.westga.cs.schoolgrades.model.Grade;

/**
 * Implements the TableModel interface, using Grades as the rows
 * 
 * @author Greg Murrell
 * @version 11/03/2020
 */
public class GradeTableModel extends AbstractTableModel {
	private List<Grade> rows;
	
	public GradeTableModel() {
		this.rows = new ArrayList<Grade>();
	}
	
	@Override
	public int getRowCount() {
		return this.rows.size();
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
		return this.rows.get(rowIndex);
	}
	
	public void addRow(Grade grade) {
		this.rows.add(grade);
	}

}
