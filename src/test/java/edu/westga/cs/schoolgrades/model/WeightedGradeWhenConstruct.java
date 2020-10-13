package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class WeightedGradeWhenConstruct {

	@Test
	public void testWeightedGradeOfSimpleGradeWithDefaultWeight() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		assertEquals(95, weighted.getValue());
	}

}
