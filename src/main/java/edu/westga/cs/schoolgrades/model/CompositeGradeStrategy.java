package edu.westga.cs.schoolgrades.model;

/**
 * 	This interface insures that a class provides a strategy by which
 * a CompositeGrade can be graded.
 * 
 * @author Greg Murrell
 * @version 10/13/2020
 */
public interface CompositeGradeStrategy {

	/**
	 * 	Calculates the given grades according to the implementing
	 * class's strategy.
	 * 
	 * @param grades	The grades to calculate
	 * @return			The grade calculated according to a grading strategy
	 */
	public double calculateGrade(CompositeGrade grades);
	
}