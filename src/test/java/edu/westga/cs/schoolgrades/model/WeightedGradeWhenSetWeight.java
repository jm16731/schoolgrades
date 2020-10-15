package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOf2() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(2);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOf1Point01() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(1.01);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOf5() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(5);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOfIntegerMAX() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(Integer.MAX_VALUE);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOfNegative1() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(-1);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOfNegative0Point01() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(-0.01);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOfNegative5() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(-5);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetAWeightOfIntegerMIN() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		try {
			weighted.setWeight(Integer.MIN_VALUE);
			fail("Set a Weight greater than 1 on WeightedGrade");
		} catch (IllegalArgumentException ex) {
			
		}
	}

}
