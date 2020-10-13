package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** 
 * @author Greg Murrell
 * @version 10/13/2020
 */
class CompositeGradeWhenSetGradingStrategy {

	@Test
	public void testSetStrategyToAverageOfGradesAfterNoArgsConstructionDoesWork() {
		CompositeGrade grades = new CompositeGrade();
		grades.setGradingStrategy(new AverageOfGradesGradingStrategy());
		assertEquals("AverageOfGradesGradingStrategy", grades.getGradingStrategy().getClass().getSimpleName());
	}
	
	@Test
	public void testSetStrategyToSumOfGradesAfterNoArgsConstructionDoesWork() {
		CompositeGrade grades = new CompositeGrade();
		grades.setGradingStrategy(new SumOfGradesGradingStrategy());
		assertEquals("SumOfGradesGradingStrategy", grades.getGradingStrategy().getClass().getSimpleName());
	}
	
	@Test
	public void testSetStrategyToNullShouldNotWork() {
		CompositeGrade grades = new CompositeGrade();
		try {
			grades.setGradingStrategy(null);
			fail("Was able to set CompositeGrade's GradingStrategy to null");
		} catch (Exception e) {
			
		}
	}

}
