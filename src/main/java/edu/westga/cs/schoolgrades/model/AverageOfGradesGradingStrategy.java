package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * 	This class implements a GradingStrategy of taking the average
 * of all the given grades.
 * 
 * @author Greg Murrell
 * @version 10/15/2020
 */
public class AverageOfGradesGradingStrategy implements GradingStrategy {
	
	/**
	 * See: {@link GradingStrategy#calculateGrade()}
	 */
	@Override
	public double calculateGrade(CompositeGrade grades) {
		double sum = 0;
		int total = 0;
		for (Grade grade : grades.getListOfGrades()) {
			sum += grade.getValue();
			total++;
		}
		return sum / total;
	}

}
