package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/15/2020
 */
class DropLowestGradeGradingStrategyWhenCalculateGrade {
	
	@Test
	public void testNoGradesShouldReturnZero() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		assertEquals(0, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testOneGradeOf95ShouldNotDropLowest() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		assertEquals(95, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testOneGradeOf0ShouldNotDropLowest() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		assertEquals(0, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testSumTwoGradesOf95And73InThatOrderShouldReturnHigherOf95() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		grades.addGrade(73);
		assertEquals(95, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testAverageTwoGradesOf95And73InThatOrderShouldReturnHigherOf95() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		grades.addGrade(73);
		assertEquals(95, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testSumTwoGradesOf73And95InThatOrderShouldReturnHigherOf95() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(73);
		grades.addGrade(95);
		assertEquals(95, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testAverageTwoGradesOf73And95InThatOrderShouldReturnHigherOf95() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(73);
		grades.addGrade(95);
		assertEquals(95, strategy.calculateGrade(grades), 0.01);
	}


	@Test
	public void testSumOfThreeGradesOf100And92And72DoesReturn192TheSumWithoutTheLowest() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 92, 72};
		grades.addGrade(values);
		assertEquals(192, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testAverageOfThreeGradesOf100And92And72DoesReturn96TheAverageWithoutTheLowest() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 92, 72};
		grades.addGrade(values);
		assertEquals(96, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testSumOfManyGradesDoesReturnTheSumMinusTheLowest() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 92, 72, 0, 78, 43, 99};
		grades.addGrade(values);
		assertEquals(484, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testAverageOfManyGradesDoesReturnTheAverageExcludingTheLowest() {
		DropLowestGradeGradingStrategy strategy = 
			new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy());
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 92, 72, 0, 78, 43, 99};
		grades.addGrade(values);
		assertEquals(80.67, strategy.calculateGrade(grades), 0.01);
	}

}
