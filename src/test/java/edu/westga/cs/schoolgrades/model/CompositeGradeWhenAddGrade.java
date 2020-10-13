package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class CompositeGradeWhenAddGrade {

	@Test
	public void testAddDouble95DoesPutThatIntoTheList() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		ArrayList<Grade> listOfGrades = grades.getListOfGrades();
		assertEquals(95, listOfGrades.get(0).getValue());
	}

}
