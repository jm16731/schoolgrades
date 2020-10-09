package edu.westga.cs.schoolgrades.model;

/**
 * 	This interface insures that a single value for the grade of a student 
 * can be obtained from the implementing class.
 * 
 * @author Greg Murrell
 * @version 10/09/2020
 */
public interface Grade {

	/**
	 * Gets the value of the student's grade
	 * 
	 * @return		Value of the student's grade
	 */
	public double getValue();
	
}
