package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 11/06/2020
 */
class CompositeGradeWhenRemoveGrade {

	@Test
	public void testRemoveGradeFromPosition0DoesRemoveItAndShiftAllValuesToLeft() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 97, 93, 55, 43, 21};
		grades.addGrade(values);
		grades.removeGrade(0);
		assertEquals(97, grades.getListOfGrades().get(0).getValue());
		assertEquals(93, grades.getListOfGrades().get(1).getValue());
		assertEquals(55, grades.getListOfGrades().get(2).getValue());
		assertEquals(43, grades.getListOfGrades().get(3).getValue());
		assertEquals(21, grades.getListOfGrades().get(4).getValue());
		try {
			double notAGrade = grades.getListOfGrades().get(5).getValue();
			fail("removeGrade didn't reduce the size of the CompositeGrade");
		} catch (IndexOutOfBoundsException ex) {
			
		}
	}
	
	@Test
	public void testRemoveGradeFromPosition3DoesRemoveItAndShiftAllValuesToLeft() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 97, 93, 55, 43, 21};
		grades.addGrade(values);
		grades.removeGrade(3);
		assertEquals(100, grades.getListOfGrades().get(0).getValue());
		assertEquals(97, grades.getListOfGrades().get(1).getValue());
		assertEquals(93, grades.getListOfGrades().get(2).getValue());
		assertEquals(43, grades.getListOfGrades().get(3).getValue());
		assertEquals(21, grades.getListOfGrades().get(4).getValue());
		try {
			double notAGrade = grades.getListOfGrades().get(5).getValue();
			fail("removeGrade didn't reduce the size of the CompositeGrade");
		} catch (IndexOutOfBoundsException ex) {
			
		}
	}
	
	@Test
	public void testRemoveGradeFromPosition5Of5DoesRemoveItAndShiftAllValuesToLeft() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 97, 93, 55, 43, 21};
		grades.addGrade(values);
		grades.removeGrade(5);
		assertEquals(100, grades.getListOfGrades().get(0).getValue());
		assertEquals(97, grades.getListOfGrades().get(1).getValue());
		assertEquals(93, grades.getListOfGrades().get(2).getValue());
		assertEquals(55, grades.getListOfGrades().get(3).getValue());
		assertEquals(43, grades.getListOfGrades().get(4).getValue());
		try {
			double notAGrade = grades.getListOfGrades().get(5).getValue();
			fail("removeGrade didn't reduce the size of the CompositeGrade");
		} catch (IndexOutOfBoundsException ex) {
			
		}
	}
	
	@Test
	public void testRemoveGradeFromInvalidLocationDoesThrowIndexOutOfBoundsException() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 97, 93, 55, 43, 21};
		grades.addGrade(values);
		try {
			grades.removeGrade(5);
			grades.removeGrade(-1);
			grades.removeGrade(100);
			grades.removeGrade(-65535);
			fail("removeGrade did something when called with IndexOutOfBounds");
		} catch (IndexOutOfBoundsException ex) {
			
		}
	}

}
