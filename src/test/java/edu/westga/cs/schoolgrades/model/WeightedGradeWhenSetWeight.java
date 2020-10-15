package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class WeightedGradeWhenSetWeight {

	@Test
	public void testSetWeightTo0Point35() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		weighted.setWeight(0.35);
		assertEquals(33.25, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testSetWeightTo0Point67() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		weighted.setWeight(0.67);
		assertEquals(63.65, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testSetWeightTo0() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		weighted.setWeight(0);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo0Point35() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(0.35);
		assertEquals(33.25, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo0Point67() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(0.67);
		assertEquals(63.65, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo0() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(0);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo1() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(1);
		assertEquals(95, weighted.getValue(), 0.01);
	}

}
