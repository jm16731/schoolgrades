package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
