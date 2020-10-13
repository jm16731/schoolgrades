package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * 	This class models a Grade that is actually composed of (iow, calculated from)
 * many other Grades.
 * 
 * @author Greg Murrell
 * @version 10/13/2020
 */
public class CompositeGrade implements Grade {
	private final ArrayList<Grade> grades;
	
	/**
	 * No-args construction of instance variables
	 */
	public CompositeGrade() {
		this.grades = new ArrayList<Grade>();
	}
	
	/**
	 * Adds the given Grade into the CompositeGrade
	 * 
	 * @param grade		The grade to be absorbed into the collective
	 */
	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}
	
	/**
	 * Gets the list of grades maintained by this CompositeGrade
	 * 
	 * @return		This CompositeGrade's list of grades
	 */
	public ArrayList<Grade> getListOfGrades() {
		return this.grades;
	}

	/**
	 * See: {@link Grade#getValue()}
	 */
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
