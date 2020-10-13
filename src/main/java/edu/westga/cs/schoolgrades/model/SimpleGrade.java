package edu.westga.cs.schoolgrades.model;

/**
 * 	This class simply wraps a double value as a student's grade, while providing
 * an implementation of the Grade interface.
 * 
 * @author Greg Murrell
 * @version 10/09/2020
 */
public class SimpleGrade implements Grade {

	private double value;
	
	/**
	 * Constructs a SimpleGrade with the given value for the grade
	 * 
	 * @param value		Value of the grade
	 */
	public SimpleGrade(double value) {
		this.setValue(value);
	}
	
	/**
	 * See: {@link Grade#getValue()}
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Sets the value of the student's grade to the specified value.
	 * 
	 * @param value		New value of the student's grade
	 * 
	 * @precondition	value > 0
	 * 
	 * @throws IllegalArgumentException		If value's range is invalid
	 */
	public void setValue(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value for grade cannot be negative");
		}
		this.value = value;
	}

}