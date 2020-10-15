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
		ArrayList<Grade> listOfGrades = grades.getListOfGrades();
		if (listOfGrades.isEmpty()) {
			return 0;
		}
		double sum = 0;
		int total = 0;
		for (Grade grade : listOfGrades) {
			sum += grade.getValue();
			total++;
		}
		return sum / total;
	}

}
