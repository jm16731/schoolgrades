package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * @author Greg Murrell
 * @version 10/13/2020
 */
class CompositeGradeWhenAddGrade {

	@Test
	public void testAddDoubleOf95DoesPutThatIntoTheList() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		assertEquals(95, grades.getListOfGrades().get(0).getValue());
	}
	
	@Test
	public void testAddDoubleOf95AndOf75DoesPutThoseIntoTheList() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		grades.addGrade(75);
		assertEquals(95, grades.getListOfGrades().get(0).getValue());
		assertEquals(75, grades.getListOfGrades().get(1).getValue());
	}
	
	@Test
	public void testAddSimpleGradeOf95AndOf75DoesPutThoseIntoTheList() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(new SimpleGrade(95));
		grades.addGrade(new SimpleGrade(75));
		assertEquals(95, grades.getListOfGrades().get(0).getValue());
		assertEquals(75, grades.getListOfGrades().get(1).getValue());
	}
	
	@Test
	public void testAddCompositeGradeDoesPutThatIntoTheList() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(new CompositeGrade());
		assertEquals("CompositeGrade", grades.getListOfGrades().get(0).getClass().getSimpleName());
	}
	
	@Test
	public void testAddWeightedGradeDoesPutThatIntoTheList() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(new WeightedGrade(new SimpleGrade(95)));
		assertEquals("WeightedGrade", grades.getListOfGrades().get(0).getClass().getSimpleName());
	}
	
	@Test
	public void testAddDoubleSimpleCompositeWeightedGradeDoesAddThemInInThatOrder() {
		CompositeGrade grades = new CompositeGrade();
		grades.addGrade(95);
		grades.addGrade(new SimpleGrade(95));
		grades.addGrade(new CompositeGrade());
		grades.addGrade(new WeightedGrade(new SimpleGrade(95)));
		assertEquals(95, grades.getListOfGrades().get(0).getValue());
		assertEquals(95, grades.getListOfGrades().get(1).getValue());
		assertEquals("CompositeGrade", grades.getListOfGrades().get(2).getClass().getSimpleName());
		assertEquals("WeightedGrade", grades.getListOfGrades().get(3).getClass().getSimpleName());
	}
	
	@Test
	public void testAddArrayOfDoublesDoesAddThemInAsSimpleGradesInThatOrderOneGradeOf100() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100};
		grades.addGrade(values);
		assertEquals(100, grades.getListOfGrades().get(0).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(0).getClass().getSimpleName());
	}
	
	@Test
	public void testAddArrayOfDoublesDoesAddThemInAsSimpleGradesInThatOrderTwoGrades() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 97};
		grades.addGrade(values);
		assertEquals(100, grades.getListOfGrades().get(0).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(0).getClass().getSimpleName());
		assertEquals(97, grades.getListOfGrades().get(1).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(1).getClass().getSimpleName());
	}
	
	@Test
	public void testAddArrayOfDoublesDoesAddThemInAsSimpleGradesInThatOrderManyGrades() {
		CompositeGrade grades = new CompositeGrade();
		double[] values = {100, 97, 93, 55, 43, 21};
		grades.addGrade(values);
		assertEquals(100, grades.getListOfGrades().get(0).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(0).getClass().getSimpleName());
		assertEquals(97, grades.getListOfGrades().get(1).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(1).getClass().getSimpleName());
		assertEquals(93, grades.getListOfGrades().get(2).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(2).getClass().getSimpleName());
		assertEquals(55, grades.getListOfGrades().get(3).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(3).getClass().getSimpleName());
		assertEquals(43, grades.getListOfGrades().get(4).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(4).getClass().getSimpleName());
		assertEquals(21, grades.getListOfGrades().get(5).getValue());
		assertEquals("SimpleGrade", grades.getListOfGrades().get(5).getClass().getSimpleName());
	}
	
	@Test
	public void testShouldThrowANullPointerExceptionIfTryToAddANullGrade() {
		try {
			CompositeGrade grades = new CompositeGrade();
			SimpleGrade grade = null;
			grades.addGrade(grade);
			fail("Null grade as added into CompositeGrade");
		} catch (NullPointerException ex) {
			
		}
	}

}
