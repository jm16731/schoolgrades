package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * @author Greg Murrell
 * @version 10/09/2020
 */
class SimpleGradeWhenConstruct {

	@Test
	void testConstructSimpleGradeWithMiddleValueShouldGetMiddleValue() {
		SimpleGrade grade = new SimpleGrade(87);
		assertEquals(87, grade.getValue());
	}
	
	@Test
	void testConstructSimpleGradeWithAnotherMiddleValueShouldReturnOtherMiddleValue() {
		SimpleGrade grade = new SimpleGrade(954);
		assertEquals(954, grade.getValue());
	}
	
	@Test
	void testConstructSimpleGradeWithValueOfZeroShouldGetValueOfZero() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue());
	}
	
	@Test
	void testConstructSimpleGradeWithValueOfOneShouldGetValueOfOne() {
		SimpleGrade grade = new SimpleGrade(1);
		assertEquals(1, grade.getValue());
	}
	
	@Test
	void testConstructSimpleGradeWithValueOfZeroPointOneShouldGetValueOfZeroPointOne() {
		SimpleGrade grade = new SimpleGrade(0.1);
		assertEquals(0.1, grade.getValue());
	}
	
	@Test
	void testConstructSimpleGradeWithValueOfDoubleMaxShouldGetValueOfIntegerMax() {
		SimpleGrade grade = new SimpleGrade(Double.MAX_VALUE);
		assertEquals(Double.MAX_VALUE, grade.getValue());
	}

}