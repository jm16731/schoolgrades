package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 	This class decorates another GradingStrategy so as to drop
 * the lowest Grade before calculating the total grade.
 * 
 * @author Greg Murrell
 * @version 10/15/2020
 */
public class DropLowestGradeGradingStrategy implements GradingStrategy {
	private final GradingStrategy gradingStrategyToBeDecorated;
	
	/**
	 * Constructs an instance with the given GradingStrategy
	 * 
	 * @param gradingStrategyToBeDecorated		GradingStrategy where the lowest grade is to be dropped
	 * 
	 * @precondition 							gradedStrategyToBeDecorated is not null
	 * 
	 * @throws NullPointerException				if gradingStrategyToBeDecorated is null
	 */
	public DropLowestGradeGradingStrategy(GradingStrategy gradingStrategyToBeDecorated) {
		if (gradingStrategyToBeDecorated == null) {
			throw new NullPointerException("Cannot construct DropLowestGradeGradingStrategy with "
					+ "a null value for gradingStrategyToBeDecorated");
		}
		this.gradingStrategyToBeDecorated = gradingStrategyToBeDecorated;
	}

	/**
	 * See: {@link GradingStrategy#calculateGrade()}
	 */
	@Override
	public double calculateGrade(CompositeGrade grades) {
		ArrayList<Grade> listOfGrades = grades.getListOfGrades();
		if (listOfGrades.size() <= 1) {
			return this.gradingStrategyToBeDecorated.calculateGrade(grades);
		}
		
		double[] values = new double[listOfGrades.size()];
		for (int i = 0; i < listOfGrades.size(); i++) {
			values[i] = listOfGrades.get(i).getValue();
		}
		java.util.Arrays.sort(values);
		double[] valuesWithoutLowest = Arrays.copyOfRange(values, 1, values.length - 1);
		
		CompositeGrade compositeWithoutLowest = new CompositeGrade();
		compositeWithoutLowest.addGrade(valuesWithoutLowest);
		return this.gradingStrategyToBeDecorated.calculateGrade(compositeWithoutLowest);
	}

}
