package edu.westga.cs.schoolgrades.model;

/**
 * 	This class models a Grade after a Weight has been applied to it.
 * 
 * @author Greg Murrell
 * @version 10/13/2020
 */
public class WeightedGrade implements Grade {
	private final Grade gradeToBeDecorated;
	
	/**
	 * Constructs a WeightedGrade that weights the given Grade
	 * 
	 * @param gradeToBeDecorated	The Grade to weigh
	 */
	public WeightedGrade(Grade gradeToBeDecorated) {
		this.gradeToBeDecorated = gradeToBeDecorated;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
