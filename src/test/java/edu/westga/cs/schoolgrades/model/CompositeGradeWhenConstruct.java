package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class CompositeGradeWhenConstruct {

	@Test
	public void testConstructDefaultCompositeGradeShouldConstruct() {
		try {
			CompositeGrade grades = new CompositeGrade();
		}
		catch (Exception e) {
			fail("CompositeGrade no-args constructor failed");
		}
	}
	
	@Test
	public void testConstructCompositeGradeWithGivenGradingStrategyShouldConstruct() {
		try {
			CompositeGrade sumGrades = new CompositeGrade(new SumOfGradesGradingStrategy());
			CompositeGrade averageGrades = new CompositeGrade(new AverageOfGradesGradingStrategy());
		}
		catch (Exception e) {
			fail("CompositeGrade gradingStrategy constructor failed");
		}
	}
	
	@Test
	public void testConstructCompositeGradeWithNullGradingStrategyShouldNotConstruct() {
		try {
			CompositeGrade grades = new CompositeGrade(null);
			fail("CompositeGrade was constructed with null GradingStrategy");
		}
		catch (Exception e) {
			
		}
	}

}
