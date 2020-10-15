package edu.westga.cs.schoolgrades.model;

/**
 * 	This class implements a GradingStrategy of taking the sum
 * of all the given grades.
 * 
 * @author Greg Murrell
 * @version 10/15/2020
 */
public class SumOfGradesGradingStrategy implements GradingStrategy {

	/**
	 * See: {@link GradingStrategy#calculateGrade()}
	 */
	@Override
	public double calculateGrade(CompositeGrade grades) {
		double sum = 0;
		for (Grade grade : grades.getListOfGrades()) {
			sum += grade.getValue();
		}
		return sum;
	}

}
