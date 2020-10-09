package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * @author Greg Murrell
 * @version 10/09/2020
 */
class SimpleGradeWhenConstruct {

	@Test
	void testSimpleGrade() {
		SimpleGrade grade = new SimpleGrade(87);
		assertEquals(87, grade.getValue());
	}

}
