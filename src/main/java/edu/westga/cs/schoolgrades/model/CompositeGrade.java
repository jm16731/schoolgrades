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
	private CompositeGradingStrategy gradingStrategy;
	
	/**
	 * 	Initializes instance variables, sets a default CompositeGradingStrategy
	 * as SumOfGradesCompositeGradingStrategy
	 */
	public CompositeGrade() {
		this(new SumOfGradesCompositeGradingStrategy());
	}
	
	/**
	 * Construct a Composite grade according to the given CompositeGradingStrategy
	 * 
	 * @param gradingStrategy		The CompositeGradingStrategy for grading
	 * 
	 * @precondition				gradingStrategy is not null
	 * 
	 * @throws NullPointerException	If gradingStrategy is null
	 */
	public CompositeGrade(CompositeGradingStrategy gradingStrategy) {
		this.grades = new ArrayList<Grade>();
		this.setGradingStrategy(gradingStrategy);
	}
	
	/**
	 * Sets the CompositeGradingStrategy to the given gradingStrategy
	 * 
	 * @param gradingStrategy		The new CompositeGradingStrategy
	 * 
	 * @precondition				gradingStrategy is not null
	 * 
	 * @throws NullPointerException	If gradingStrategy is null
	 */
	public void setGradingStrategy(CompositeGradingStrategy gradingStrategy) {
		if (gradingStrategy == null) {
			throw new NullPointerException("CompositeGrade's gradingStrategy cannot be null");
		}
		this.gradingStrategy = gradingStrategy;
	}
	
	/**
	 * Gets this CompositeGrade's CompositeGradingStrategy
	 * 
	 * @return		This instance's CompositeGradingStrategy
	 */
	public CompositeGradingStrategy getGradingStrategy() {
		return this.gradingStrategy;
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
	 * Adds the given Grade into the CompositeGrade
	 * 
	 * @param grade		The grade to be absorbed into the collective
	 * 
	 * @precondition	grade is not null
	 * 
	 * @throws NullPointerException	If grade is null
	 */
	public void addGrade(Grade grade) {
		if (grade == null) {
			throw new NullPointerException("Cannot add a null grade to CompositeGrade");
		}
		this.grades.add(grade);
	}
	
	/**
	 * See: {@link Grade#getValue()}
	 */
	@Override
	public double getValue() {
		return this.gradingStrategy.calculateGrade(this);
	}

}
