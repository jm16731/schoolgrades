package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;
	
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	
	private List<Grade> grades;
	
	@BeforeEach
	public void setUp() throws Exception {
		grade0 = mock(Grade.class);
		when(grade0.getValue()).thenReturn(10.0);
		grade1 = mock(Grade.class);
		when(grade1.getValue()).thenReturn(20.0);
		grade2 = mock(Grade.class);
		when(grade2.getValue()).thenReturn(30.0);
		
		grades = new ArrayList<Grade>();
		
		childStrategy = mock(GradeCalculationStrategy.class);
		when(childStrategy.calculate(grades)).thenReturn(0.00);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(grades);
	}
	
	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(grade0);
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(grades);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(grade0);
		grades.add(grade1);
		grades.add(grade2);
		dropLowestStrategy.calculate(grades);
		
		ArrayList<Grade> gradesMinusOne = new ArrayList<Grade>();
		gradesMinusOne.add(grade1);
		gradesMinusOne.add(grade2);
		verify(childStrategy).calculate(gradesMinusOne);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade0);
		dropLowestStrategy.calculate(grades);
		
		ArrayList<Grade> gradesMinusOne = new ArrayList<Grade>();
		gradesMinusOne.add(grade1);
		gradesMinusOne.add(grade2);
		verify(childStrategy).calculate(gradesMinusOne);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		dropLowestStrategy.calculate(grades);
		
		ArrayList<Grade> gradesMinusOne = new ArrayList<Grade>();
		gradesMinusOne.add(grade1);
		gradesMinusOne.add(grade2);
		verify(childStrategy).calculate(gradesMinusOne);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		grades.add(grade0);
		dropLowestStrategy.calculate(grades);
		
		ArrayList<Grade> gradesMinusOne = new ArrayList<Grade>();
		gradesMinusOne.add(grade1);
		gradesMinusOne.add(grade2);
		gradesMinusOne.add(grade0);
		verify(childStrategy).calculate(gradesMinusOne);
	}
}
