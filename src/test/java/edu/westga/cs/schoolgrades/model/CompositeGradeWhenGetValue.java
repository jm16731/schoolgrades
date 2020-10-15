package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/15/2020
 */
class CompositeGradeWhenGetValue {

	@Test
	public void testFirstSetOfGradesReturnsDifferentAndExpectedValuesForAllFourOfSumOrAverageWithOrWithoutDropLowest() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(new double[] {100, 99, 87, 43, 99, 53, 24, 87, 75, 89});

		assertEquals(756, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new AverageOfGradesGradingStrategy());
		assertEquals(75.6, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy()));
		assertEquals(732, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy()));
		assertEquals(81.33, grades.getValue(), 0.01);
	}
	
	@Test
	public void testSecondSetOfGradesReturnsDifferentAndExpectedValuesForAllFourOfSumOrAverageWithOrWithoutDropLowest() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(new double[] {53, 67, 41, 31, 52, 43});

		assertEquals(287, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new AverageOfGradesGradingStrategy());
		assertEquals(47.83, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy()));
		assertEquals(256, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy()));
		assertEquals(51.2, grades.getValue(), 0.01);
	}
	
	/**
	 * Look ma', an actually good student
	 */
	@Test
	public void testThirdSetOfGradesReturnsDifferentAndExpectedValuesForAllFourOfSumOrAverageWithOrWithoutDropLowest() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(new double[] {100, 98, 87, 99, 100, 89, 91, 94, 100, 100, 96});

		assertEquals(1054, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new AverageOfGradesGradingStrategy());
		assertEquals(95.81, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy()));
		assertEquals(967, grades.getValue(), 0.01);
		
		grades.setGradingStrategy(new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy()));
		assertEquals(96.7, grades.getValue(), 0.01);
	}

}
