
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lab2.Triangle;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class TriangleTest {

	private Triangle triangle;

	
	@BeforeClass
	/*
	 * The method run once before any of the test methods in the class.
	 */
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	/* 
	 * The method will be run after all the tests in the class have been run
	 */
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	/*
	 * Initializes common objects. The method will be run before the Test method.
	 */
	public void setUp() throws Exception {
		triangle = new Triangle(1,1,1);
	}

	@After
	/*
	 *   Cleanup method. This method will be run after the Test method is completed
	 */
	public void tearDown() throws Exception {
		triangle = null;
	}

	// Test cases for classify
	// 1
	@Test
	public void testClassifyEquilateral() {
		triangle.setSideLengths(4, 4, 4);
		assertEquals("equilateral", triangle.classify());
	}
	// 2
	@Test
	public void testClassifyIsosceles() {
		triangle.setSideLengths(2, 2, 3);
		assertEquals("isosceles", triangle.classify());
	}
	// 3
	@Test
	public void testClassifyRightAngled() {
		triangle.setSideLengths(5, 12, 13);
		assertEquals("right-angled", triangle.classify());
	}
	// 4
	@Test
	public void testClassifyScalene() {
		triangle.setSideLengths(5, 6, 7);
		assertEquals("scalene", triangle.classify());
	}
	// 5
	@Test
	public void testClassifyImpossible() {
		triangle.setSideLengths(2, 2, 4);
		assertEquals("impossible", triangle.classify());
	}
	// 6
	@Test
	public void testClassifyBoundaryEquilateral() {
		triangle.setSideLengths(1, 1, 1);
		assertEquals("equilateral", triangle.classify());
	}
	// 7
	@Test
	public void testClassifyLargeEquilateral() {
		triangle.setSideLengths(1000, 1000, 1000);
		assertEquals("equilateral", triangle.classify());
	}
	// 8
	@Test
	public void testClassifyMinimumIsosceles() {
		triangle.setSideLengths(2, 2, 3);
		assertEquals("isosceles", triangle.classify());
	}
	// 9
	@Test
	public void testClassifyMaximumIsosceles() {
		triangle.setSideLengths(666, 666, 999);
		assertEquals("isosceles", triangle.classify());
	}
	// 10
	@Test
	public void testClassifyMinimumRightAngled() {
		triangle.setSideLengths(3, 4, 5);
		assertEquals("right-angled", triangle.classify());
	}
	// 11
	@Test
	public void testClassifyMaximumRightAngled() {
		triangle.setSideLengths(3000, 4000, 5000);
		assertEquals("right-angled", triangle.classify());
	}
	// 12
	@Test
	public void testClassifyMinimumScalene() {
		triangle.setSideLengths(4, 5, 6);
		assertEquals("scalene", triangle.classify());
	}
	// 13
	@Test
	public void testClassifyMaximumScalene() {
		triangle.setSideLengths(998, 999, 1000);
		assertEquals("scalene", triangle.classify());
	}
	// 14
	@Test
	public void testClassifyMinimumImpossible() {
		triangle.setSideLengths(0, 1, 1);
		assertEquals("impossible", triangle.classify());
	}
	// 15
	@Test
	public void testClassifyNegativeImpossible() {
		triangle.setSideLengths(-1000, 1, 1);
		assertEquals("impossible", triangle.classify());
	}

	// Test cases for getArea()
	// 16
	@Test
	public void testGetAreaValidTriangle() {
		triangle.setSideLengths(4, 4, 4);
		assertEquals(6.93, triangle.getArea(), 0.01);
	}
	// 17
	@Test
	public void testGetAreaImpossibleTriangle() {
		triangle.setSideLengths(2, 2, 4);
		assertEquals(-1.0, triangle.getArea(), 0.01);
	}
	// 18
	@Test
	public void testGetAreaInvalidSideLength() {
		triangle.setSideLengths(-1, 4, 4);
		assertEquals(-1.0, triangle.getArea(), 0.01);
	}

	// Test cases for getArea()
	// 19
	@Test
	public void testGetAreaMinimalValidTriangle() {
		triangle.setSideLengths(1, 1, 1);
		assertEquals(0, triangle.getArea(), 0.01);
	}
	// 20
	@Test
	public void testGetAreaLargeValidTriangle() {
		triangle.setSideLengths(1000, 1000, 1000);
		assertEquals(433000, triangle.getArea(), 0.01);
	}
	// 21
	@Test
	public void testGetAreaJustPossibleTriangle() {
		triangle.setSideLengths(2, 2, 3);
		assertEquals(1.98, triangle.getArea(), 0.01);
	}
	// 22
	@Test
	public void testGetAreaJustImpossibleTriangle() {
		triangle.setSideLengths(1, 1, 2);
		assertEquals(-1.0, triangle.getArea(), 0.01);
	}
	// 23
	@Test
	public void testGetAreaMinimumInvalidSideLengths() {
		triangle.setSideLengths(0, 1, 1);
		assertEquals(-1, triangle.getArea(), 0.01);
	}
	// 24
	@Test
	public void testGetAreaLargeInvalidSideLengths() {
		triangle.setSideLengths(-1000, 1, 1);
		assertEquals(-1, triangle.getArea(), 0.01);
	}

	// Test cases for getPerimeter()
	// 25
	@Test
	public void testGetPerimeterValidTriangle() {
		triangle.setSideLengths(4, 5, 6);
		assertEquals(15, triangle.getPerimeter());
	}
	// 26
	@Test
	public void testGetPerimeterImpossibleTriangle() {
		triangle.setSideLengths(2, 2, 4);
		assertEquals(-1, triangle.getPerimeter());
	}
	// 27
	@Test
	public void testGetPerimeterInvalidInputs() {
		triangle.setSideLengths(-1, 1, 2);
		assertEquals(-1, triangle.getPerimeter());
	}
	// 28
	@Test
	public void testGetPerimeterMinimalValidTriangle() {
		triangle.setSideLengths(1, 1, 1);
		assertEquals(3, triangle.getPerimeter());
	}
	// 29
	@Test
	public void testGetPerimeterLargeValidTriangle() {
		triangle.setSideLengths(1000, 1000, 1000);
		assertEquals(3000, triangle.getPerimeter());
	}
	// 30
	@Test
	public void testGetPerimeterJustPossibleTriangle() {
		triangle.setSideLengths(2, 2, 3);
		assertEquals(7, triangle.getPerimeter());
	}
	// 31
	@Test
	public void testGetPerimeterJustImpossibleTriangle() {
		triangle.setSideLengths(1, 1, 2);
		assertEquals(-1, triangle.getPerimeter());
	}
	// 32
	@Test
	public void testGetPerimeterMinimumInvalidTriangle() {
		triangle.setSideLengths(0, 1, 1);
		assertEquals(-1, triangle.getPerimeter());
	}
	// 33
	@Test
	public void testGetPerimeterLargeInvalidTriangle() {
		triangle.setSideLengths(-1000, 1, 1);
		assertEquals(-1, triangle.getPerimeter());
	}

	// Test cases for getSideLengths()
	// 34
	@Test
	public void testGetSideLengths() {
		triangle.setSideLengths(2, 3, 4);
		assertEquals(new String("2,3,4"), triangle.getSideLengths());
	}
	// 35
	@Test
	public void testGetSideLengthsMinimalValidTriangle() {
		triangle.setSideLengths(1, 1, 1);
		assertEquals(new String("1,1,1"), triangle.getSideLengths());
	}
	// 36
	@Test
	public void testGetSideLengthsMaximumValidTriangle() {
		triangle.setSideLengths(1000, 1000, 1000);
		assertEquals(new String("1000,1000,1000"), triangle.getSideLengths());
	}

	// Test cases for isEquilateral()
	// 37
	@Test
	public void testIsEquilateralTrue() {
		triangle.setSideLengths(2, 2, 2);
		assertTrue(triangle.isEquilateral());
	}
	// 38
	@Test
	public void testIsEquilateralFalse() {
		triangle.setSideLengths(2, 2, 3);
		assertFalse(triangle.isEquilateral());
	}
	// 39
	@Test
	public void testIsEquilateralMinimumEquilateralTriangle() {
		triangle.setSideLengths(1, 1, 1);
		assertTrue(triangle.isEquilateral());
	}
	// 40
	@Test
	public void testIsEquilateralMaximumEquilateralTriangle() {
		triangle.setSideLengths(1000, 1000, 1000);
		assertTrue(triangle.isEquilateral());
	}
	// 41
	@Test
	public void testIsEquilateralMinimumNonEquilateralTriangle() {
		triangle.setSideLengths(3, 4, 5);
		assertFalse(triangle.isEquilateral());
	}
	// 42
	@Test
	public void testIsEquilateralMaximumNonEquilateralTriangle() {
		triangle.setSideLengths(1000, 999, 998);
		assertFalse(triangle.isEquilateral());
	}

	// Test cases for isImpossible()
	// 43
	@Test
	public void testIsImpossibleTrue() {
		triangle.setSideLengths(5, 3, 20);
		assertTrue(triangle.isImpossible());
	}
	// 44
	@Test
	public void testIsImpossibleFalse() {
		triangle.setSideLengths(3, 4, 5);
		assertFalse(triangle.isImpossible());
	}
	// 45
	@Test
	public void testIsImpossibleMinimumImpossibleTriangle() {
		triangle.setSideLengths(1, 1, 2);
		assertTrue(triangle.isImpossible());
	}
	// 46
	@Test
	public void testIsImpossibleMaximumImpossibleTriangle() {
		triangle.setSideLengths(1000, 1000, 2000);
		assertTrue(triangle.isImpossible());
	}
	// 47
	@Test
	public void testIsImpossibleMinimumNonImpossibleTriangle() {
		triangle.setSideLengths(3, 4, 5);
		assertFalse(triangle.isImpossible());
	}
	// 48
	@Test
	public void testIsImpossibleMaximumNonImpossibleTriangle() {
		triangle.setSideLengths(1000, 999, 998);
		assertFalse(triangle.isImpossible());
	}

	// Test cases for isIsosceles()
	// 49
	@Test
	public void testIsIsoscelesTrue() {
		triangle.setSideLengths(2, 2, 3);
		assertTrue(triangle.isIsosceles());
	}
	// 50
	@Test
	public void testIsIsoscelesFalse() {
		triangle.setSideLengths(3, 4, 5);
		assertFalse(triangle.isIsosceles());
	}
	// 51
	@Test
	public void testIsIsoscelesMinimumIsoscelesTriangle() {
		triangle.setSideLengths(2, 2, 3);
		assertTrue(triangle.isIsosceles());
	}
	// 52
	@Test
	public void testIsIsoscelesMaximumIsoscelesTriangle() {
		triangle.setSideLengths(666, 666, 999);
		assertTrue(triangle.isIsosceles());
	}
	// 53
	@Test
	public void testIsIsoscelesMinimumNonIsoscelesTriangle() {
		triangle.setSideLengths(3, 4, 5);
		assertFalse(triangle.isIsosceles());
	}
	// 54
	@Test
	public void testIsIsoscelesMaximumNonIsoscelesTriangle() {
		triangle.setSideLengths(1000, 999, 998);
		assertFalse(triangle.isIsosceles());
	}

	// Test cases for isRightAngled()
	// 55
	@Test
	public void testIsRightAngledTrue() {
		triangle.setSideLengths(5, 12, 13);
		assertTrue(triangle.isRightAngled());
	}
	// 56
	@Test
	public void testIsRightAngledFalse() {
		triangle.setSideLengths(1, 1, 1);
		assertFalse(triangle.isRightAngled());
	}
	// 57
	@Test
	public void testIsRightAngledMinimumRightAngledTriangle() {
		triangle.setSideLengths(3, 4, 5);
		assertTrue(triangle.isRightAngled());
	}
	// 58
	@Test
	public void testIsRightAngledMaximumRightAngledTriangle() {
		triangle.setSideLengths(3000, 4000, 5000);
		assertTrue(triangle.isRightAngled());
	}
	// 59
	@Test
	public void testIsRightAngledMinimumNonRightAngledTriangle() {
		triangle.setSideLengths(1, 1, 1);
		assertFalse(triangle.isRightAngled());
	}
	// 60
	@Test
	public void testIsRightAngledMaximumNonRightAngledTriangle() {
		triangle.setSideLengths(1000, 999, 998);
		assertFalse(triangle.isRightAngled());
	}

	// Test cases for isScalene()
	// 61
	@Test
	public void testIsScaleneTrue() {
		triangle.setSideLengths(5, 6, 7);
		assertTrue(triangle.isScalene());
	}
	// 62
	@Test
	public void testIsScaleneFalse() {
		triangle.setSideLengths(2, 2, 5);
		assertFalse(triangle.isScalene());
	}
	// 63
	@Test
	public void testIsScaleneMinimumScaleneTriangle() {
		triangle.setSideLengths(4, 5, 6);
		assertTrue(triangle.isScalene());
	}
	// 64
	@Test
	public void testIsScaleneMaximumScaleneTriangle() {
		triangle.setSideLengths(1000, 999, 998);
		assertTrue(triangle.isScalene());
	}
	// 65
	@Test
	public void testIsScaleneMinimumNonScaleneTriangle() {
		triangle.setSideLengths(1, 1, 1);
		assertFalse(triangle.isScalene());
	}
	// 66
	@Test
	public void testIsScaleneMaximumNonScaleneTriangle() {
		triangle.setSideLengths(666, 666, 999);
		assertFalse(triangle.isScalene());
	}
	// Test cases for setSideLengths()
	// 67
	@Test
	public void testSetSideLengthsValid() {
		triangle.setSideLengths(2, 3, 4);
		assertEquals(new String("2,3,4"), triangle.getSideLengths());
	}
	// 68
	@Test
	public void testSetSideLengthsInvalid() {
		triangle.setSideLengths(-1, -1, -1);
		assertEquals(new String("-1,-1,-1"), triangle.getSideLengths()); // Assuming default side lengths are 0
	}

}
