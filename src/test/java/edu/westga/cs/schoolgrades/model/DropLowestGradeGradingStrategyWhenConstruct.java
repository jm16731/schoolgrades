package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/15/2020
 */
class DropLowestGradeGradingStrategyWhenConstruct {

	@Test
	public void testConstructCompositeGradeWithGivenGradingStrategyShouldConstruct() {
		try {
			DropLowestGradeGradingStrategy decoratedSum = 
				new DropLowestGradeGradingStrategy(new SumOfGradesGradingStrategy());
			DropLowestGradeGradingStrategy decoratedAverage = 
				new DropLowestGradeGradingStrategy(new AverageOfGradesGradingStrategy());
			DropLowestGradeGradingStrategy decoratedDecoratedAverage = 
				new DropLowestGradeGradingStrategy(new DropLowestGradeGradingStrategy(
					new AverageOfGradesGradingStrategy()));
		}
		catch (Exception e) {
			fail("DropLowestGradeGradingStrategy constructor failed");
		}
	}
	
	@Test
	public void testConstructCompositeGradeWithNullGradingStrategyShouldNotConstruct() {
		try {
			DropLowestGradeGradingStrategy grades = new DropLowestGradeGradingStrategy(null);
			fail("DropLowestGradeGradingStrategy was constructed with null GradingStrategy");
		}
		catch (Exception e) {
			
		}
	}
}
