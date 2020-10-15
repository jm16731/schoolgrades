package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class WeightedGradeWhenConstruct {

	@Test
	public void testWeightedGradeOfSimpleGradeOf95WithDefaultWeight() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade);
		assertEquals(95, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf80WithDefaultWeight() {
		SimpleGrade grade = new SimpleGrade(80);
		WeightedGrade weighted = new WeightedGrade(grade);
		assertEquals(80, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf0WithDefaultWeight() {
		SimpleGrade grade = new SimpleGrade(0);
		WeightedGrade weighted = new WeightedGrade(grade);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf95WithWeightOf0Point5() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.5);
		assertEquals(47.50, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf80WithWeightOf0Point5() {
		SimpleGrade grade = new SimpleGrade(80);
		WeightedGrade weighted = new WeightedGrade(grade, 0.5);
		assertEquals(40.00, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf0WithWeightOf0Point5() {
		SimpleGrade grade = new SimpleGrade(0);
		WeightedGrade weighted = new WeightedGrade(grade, 0.5);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf95WithWeightOf0Point33() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0.33);
		assertEquals(31.35, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf80WithWeightOf0Point33() {
		SimpleGrade grade = new SimpleGrade(80);
		WeightedGrade weighted = new WeightedGrade(grade, 0.33);
		assertEquals(26.40, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf0WithWeightOf0Point33() {
		SimpleGrade grade = new SimpleGrade(0);
		WeightedGrade weighted = new WeightedGrade(grade, 0.33);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf95WithWeightOf0() {
		SimpleGrade grade = new SimpleGrade(95);
		WeightedGrade weighted = new WeightedGrade(grade, 0);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf80WithWeightOf0() {
		SimpleGrade grade = new SimpleGrade(80);
		WeightedGrade weighted = new WeightedGrade(grade, 0);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	@Test
	public void testWeightedGradeOfSimpleGradeOf0WithWeightOf0() {
		SimpleGrade grade = new SimpleGrade(0);
		WeightedGrade weighted = new WeightedGrade(grade, 0);
		assertEquals(0, weighted.getValue(), 0.01);
	}
	
	/**
	 * Look ma', no overflow errors
	 */
	@Test
	public void testWeightedGradeOfSimpleGradeOfDoubleMAXWithDefaultWeightOf1() {
		SimpleGrade grade = new SimpleGrade(Double.MAX_VALUE);
		WeightedGrade weighted = new WeightedGrade(grade);
		assertEquals(Double.MAX_VALUE, weighted.getValue(), 0.01);
	}

}
