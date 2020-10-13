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
	private GradingStrategy strategy;
	
	/**
	 * 	Initializes instance variables, sets a default GradingStrategy
	 * as SumOfGradesGradingStrategy
	 */
	public CompositeGrade() {
		this(new SumOfGradesGradingStrategy());
	}
	
	/**
	 * Construct a Composite grade according to the given GradingStrategy
	 * 
	 * @param strategy				The GradingStrategy for grading
	 * 
	 * @precondition				strategy is not null
	 * 
	 * @throws NullPointerException	If strategy is null
	 */
	public CompositeGrade(GradingStrategy strategy) {
		this.grades = new ArrayList<Grade>();
		this.setGradingStrategy(strategy);
	}
	
	/**
	 * Sets the GradingStrategy to the given strategy
	 * 
	 * @param strategy				The new GradingStrategy
	 * 
	 * @precondition				strategy is not null
	 * 
	 * @throws NullPointerException	If strategy is null
	 */
	public void setGradingStrategy(GradingStrategy strategy) {
		if (strategy == null) {
			throw new NullPointerException("CompositeGrade's GradingStrategy cannot be null");
		}
		this.strategy = strategy;
	}
	
	/**
	 * Gets this CompositeGrade's GradingStrategy
	 * 
	 * @return		This instance's GradingStrategy
	 */
	public GradingStrategy getGradingStrategy() {
		return this.strategy;
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
	 * Adds the given grade as a SimpleGrade into the CompositeGrade
	 * 
	 * @param grade		The grade to be absored into the collective
	 */
	public void addGrade(double grade) {
		this.addGrade(new SimpleGrade(grade));
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
		return this.strategy.calculateGrade(this);
	}

}
