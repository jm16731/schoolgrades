package edu.westga.cs.schoolgrades.views;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import edu.westga.cs.schoolgrades.model.Grade;

/**
 * TableModelListener for GradeTableModel class
 * 
 * @author Greg Murrell
 * @verison 11/06/2020
 */
public class GradeTableModelListener implements TableModelListener {

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int type = e.getType();
		GradeTableModel model = (GradeTableModel) e.getSource();
		Grade data = (Grade) model.getValueAt(row, 1);
	}

}
