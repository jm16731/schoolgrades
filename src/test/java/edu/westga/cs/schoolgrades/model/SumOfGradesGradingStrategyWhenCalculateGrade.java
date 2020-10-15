package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/15/2020
 */
class SumOfGradesGradingStrategyWhenCalculateGrade {

	@Test
	public void testNoGradesReturnSumOfGradesEquals0() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		assertEquals(0, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf0ReturnSumOfGradesEquals0() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		assertEquals(0, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf1ReturnSumOfGradesEquals1() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(1);
		assertEquals(1, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf3ReturnSumOfGradesEquals3() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(3);
		assertEquals(3, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf17ReturnSumOfGradesEquals17() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(17);
		assertEquals(17, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf93ReturnSumOfGradesEquals93() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(93);
		assertEquals(93, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf93And100ReturnSumOfGradesEquals193() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(93);
		grades.addGrade(100);
		assertEquals(193, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf0And57ReturnSumOfGradesEquals57() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		grades.addGrade(57);
		assertEquals(57, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOf0And57And93ReturnSumOfGradesEquals150() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		grades.addGrade(57);
		grades.addGrade(93);
		assertEquals(150, strategy.calculateGrade(grades), 0.01);
	}
	
	@Test
	public void testGradeOfManyReturnSumOfGradesEqualsTheSum() {
		SumOfGradesGradingStrategy strategy = new SumOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		grades.addGrade(57);
		grades.addGrade(93);
		grades.addGrade(43);
		grades.addGrade(57);
		grades.addGrade(100);
		grades.addGrade(88);
		grades.addGrade(21);
		grades.addGrade(11);
		assertEquals(470, strategy.calculateGrade(grades), 0.01);
	}


}
