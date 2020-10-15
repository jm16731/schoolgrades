package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/15/2020
 */
class AverageOfGradesGradingStrategyWhenCalculateGrade {

	@Test
	public void testNoGradesReturnsAverageOfZero() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		assertEquals(0, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testOneGradeOf95ReturnsAverageOf95() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		assertEquals(95, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testOneGradeOf43ReturnsAverageOf43() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(43);
		assertEquals(43, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testOneGradeOf1ReturnsAverageOf1() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(1);
		assertEquals(1, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testOneGradeOf0ReturnsAverageOf0() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		assertEquals(0, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testTwoGrades75And100DoesReturnTheMidpointOfThoseTwoGrades() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(50);
		grades.addGrade(100);
		assertEquals(75, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testTwoGrades80And30DoesReturnTheMidpointOfThoseTwoGrades() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(30);
		grades.addGrade(80);
		assertEquals(55, strategy.calculateGrade(grades));
	}
	
	@Test
	public void testTwoGrades11And88DoesReturnTheMidpointOfThoseTwoGrades() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(11);
		grades.addGrade(88);
		
		BigDecimal accurateDouble = new BigDecimal(strategy.calculateGrade(grades));
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(49.50, accurateDouble.doubleValue());
	}
	
	@Test
	public void testThreeGrades50And75And100DoesReturnTheAverageOfSaidThree() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(50);
		grades.addGrade(100);
		grades.addGrade(75);
		
		BigDecimal accurateDouble = new BigDecimal(strategy.calculateGrade(grades));
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(75.00, accurateDouble.doubleValue());
	}
	
	@Test
	public void testThreeGrades83And97And42DoesReturnTheAverageOfSaidThree() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(83);
		grades.addGrade(97);
		grades.addGrade(42);
		
		BigDecimal accurateDouble = new BigDecimal(strategy.calculateGrade(grades));
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(74.00, accurateDouble.doubleValue());
	}
	
	@Test
	public void testThreeGrades0And89And57DoesReturnTheAverageOfSaidThree() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		grades.addGrade(89);
		grades.addGrade(57);
		
		BigDecimal accurateDouble = new BigDecimal(strategy.calculateGrade(grades));
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(48.67, accurateDouble.doubleValue());
	}
	
	@Test
	public void testNineGradesDoesReturnTheAverageOfSaidNine() {
		AverageOfGradesGradingStrategy strategy = new AverageOfGradesGradingStrategy();
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(0);
		grades.addGrade(89);
		grades.addGrade(57);
		grades.addGrade(63);
		grades.addGrade(77);
		grades.addGrade(42);
		grades.addGrade(100);
		grades.addGrade(99);
		grades.addGrade(93);
		
		BigDecimal accurateDouble = new BigDecimal(strategy.calculateGrade(grades));
		accurateDouble = accurateDouble.setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(68.89, accurateDouble.doubleValue());
	}

}
