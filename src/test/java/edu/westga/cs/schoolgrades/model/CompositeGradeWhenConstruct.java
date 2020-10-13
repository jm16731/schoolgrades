package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	@Test
	public void testListOfGradesIsEmptyAfterNoArgsConstruction() {
		CompositeGrade grades = new CompositeGrade();
		assertEquals(true, grades.getListOfGrades().isEmpty());
	}
	
	@Test
	public void testListOfGradesIsEmptyAfterConstructionWithGradingStrategy() {
		CompositeGrade grades = new CompositeGrade(new DropLowestGradeGradingStrategy());
		assertEquals(true, grades.getListOfGrades().isEmpty());
	}
	
	@Test
	public void testGradingStrategyAfterNoArgsConstructionShouldBeSumOfGrades() {
		CompositeGrade grades = new CompositeGrade();
		assertEquals("SumOfGradesGradingStrategy", grades.getGradingStrategy().getClass().getSimpleName());
	}
	
	@Test
	public void testGradingStrategyAfterConstructionWithAverageOfGradesShouldReturnAverageOfGrades() {
		CompositeGrade grades = new CompositeGrade(new AverageOfGradesGradingStrategy());
		assertEquals("AverageOfGradesGradingStrategy", grades.getGradingStrategy().getClass().getSimpleName());
	}
	
	@Test
	public void testGradingStrategyAfterConstructionWithDropLowestGradeShouldReturnDropLowestGrade() {
		CompositeGrade grades = new CompositeGrade(new DropLowestGradeGradingStrategy());
		assertEquals("DropLowestGradeGradingStrategy", grades.getGradingStrategy().getClass().getSimpleName());
	}

}
