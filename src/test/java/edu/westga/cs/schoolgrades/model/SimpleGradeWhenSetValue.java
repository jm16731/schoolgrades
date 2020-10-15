package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class SimpleGradeWhenSetValue {
	SimpleGrade grade;

	@BeforeEach
	public void initialize() {
		this.grade = new SimpleGrade(100);
	}
	
	@Test
	public void testSetValueToZero() {
		this.grade.setValue(0);
		assertEquals(0, this.grade.getValue());
	}
	
	@Test
	public void testSetValueToOne() {
		this.grade.setValue(1);
		assertEquals(1, this.grade.getValue());
	}
	
	@Test
	public void testSetValueToFourteen() {
		this.grade.setValue(14);
		assertEquals(14, this.grade.getValue());
	}
	
	@Test
	public void testSetValueToSeventyFive() {
		this.grade.setValue(75);
		assertEquals(75, this.grade.getValue());
	}
	
	@Test
	public void testSetValueToOneHundred() {
		this.grade.setValue(100);
		assertEquals(100, this.grade.getValue());
	}
	
	@Test
	public void testSetValueToOneHundredFiftyOne() {
		this.grade.setValue(151);
		assertEquals(151, this.grade.getValue());
	}
	
	@Test
	public void testSetValueToDoubleMAX() {
		this.grade.setValue(Double.MAX_VALUE);
		assertEquals(Double.MAX_VALUE, this.grade.getValue());
	}
	
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfTryToSetNegativeGrade() {
		try {
			this.grade.setValue(-1);
			fail("Set the grade to a negative value");
		} catch (IllegalArgumentException ex) {
			
		}
	}

}
