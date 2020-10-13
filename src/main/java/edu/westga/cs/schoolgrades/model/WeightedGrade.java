package edu.westga.cs.schoolgrades.model;

/**
 * 	This class models a Grade after a Weight has been applied to it.
 * 
 * @author Greg Murrell
 * @version 10/13/2020
 */
public class WeightedGrade implements Grade {
	private final Grade gradeToBeDecorated;
	private double weight;
	
	/**
	 * 	Constructs a WeightedGrade that weighs the given Grade
	 * with the default weight of 1.
	 * 
	 * @param gradeToBeDecorated	The Grade to weigh
	 */
	public WeightedGrade(Grade gradeToBeDecorated) {
		this(gradeToBeDecorated, 1);
	}
	
	/**
	 * 	Constructs a WeightedGrade that weighs the given Grade
	 * with the given weight.
	 * 
	 * @param gradeToBeDecorated	The Grade to weigh
	 * @param weight				How much to weight the grade
	 */
	public WeightedGrade(Grade gradeToBeDecorated, double weight) {
		this.gradeToBeDecorated = gradeToBeDecorated;
		this.weight = weight;
	}

	/**
	 * See: {@link Grade#getValue()}
	 */
	@Override
	public double getValue() {
		return this.gradeToBeDecorated.getValue() * this.weight;
	}

}