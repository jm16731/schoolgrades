package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		
		BigDecimal accurateDouble = new BigDecimal(weighted.getValue());
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(33.25, accurateDouble.doubleValue());
	}
	
	@Test
	public void testSetWeightTo0Point67() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		weighted.setWeight(0.67);
		
		BigDecimal accurateDouble = new BigDecimal(weighted.getValue());
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(63.65, accurateDouble.doubleValue());
	}
	
	@Test
	public void testSetWeightTo0() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		weighted.setWeight(0);
		assertEquals(0, weighted.getValue());
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo0Point35() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(0.35);
		
		BigDecimal accurateDouble = new BigDecimal(weighted.getValue());
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(33.25, accurateDouble.doubleValue());
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo0Point67() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(0.67);
		
		BigDecimal accurateDouble = new BigDecimal(weighted.getValue());
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(63.65, accurateDouble.doubleValue());
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo0() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(0);
		assertEquals(0, weighted.getValue());
	}
	
	@Test
	public void testSetWeightWhenNotInitiallyConstructedAsDefaultTo1() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.01);
		weighted.setWeight(1);
		assertEquals(95, weighted.getValue());
	}

}
