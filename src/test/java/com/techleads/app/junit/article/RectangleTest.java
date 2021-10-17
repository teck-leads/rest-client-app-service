package com.techleads.app.junit.article;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void tryAssertTrue() {
		Rectangle rectangle = new Rectangle(10, 10);
		assertTrue(rectangle.isSuare());
	}

	@Test
	void tryAssertFalse() {
		Rectangle rectangle = new Rectangle(1, 10);
		assertFalse(rectangle.isSuare());
	}

	@Test
	void tryAssertTrue1() {
		Rectangle rectangle = new Rectangle(10, 10);
		assertTrue(rectangle.isSuare(), "Rectangle with same width and height should be same");
	}

	@Test
	void tryAssetNull() {
		Object obj = null;
		assertNull(obj);
	}

	@Test
	void tryAssetNotNull() {
		Object obj = new Rectangle(1, 10);
		assertNotNull(obj);
	}

	@Test
	void tryAssertEquals() {
		assertEquals(16, new Rectangle(2, 8).getArea());
	}

	@Test
	void tryAssertEqualsWithStrings() {
//	assertEquals("Hello World Now", "hello world now");
		assertEquals("Hello World Now", "Hello World Now");
	}

	@Test
	void tryAssertNotEquals() {
		assertNotEquals(9999, new Rectangle(1, 3).getArea());
	}

	@Test
	void tryAssertEqualsWithDouble() {

		double aspectRatio = new Rectangle(1, 2).getAspectRatio();
		assertNotEquals(0.3333333333333333, aspectRatio, 0.123);
	}

	@Test
	void tryAssertEqualsWithObject() {

		assertEquals(new Rectangle(10, 10), new Rectangle(10, 10));
	}

	@Test
	void tryWithAssertSame() {
		Rectangle r1 = new Rectangle(4, 5);
		Rectangle r2Ref = r1;

		assertSame(r1, r2Ref);
		Rectangle duplicateOfR1 = new Rectangle(4, 5);
		assertNotSame(r1, duplicateOfR1);
		assertEquals(r1, duplicateOfR1);
	}

	@Test
	void tryAssertArray() {
		Rectangle r1 = new Rectangle(4, 5);
		assertArrayEquals(new int[] { 4, 5 }, r1.getSides());
	}

	@Test
	void tryAssertList() {
		Rectangle r1 = new Rectangle(4, 8);

		assertEquals(Arrays.asList(4, 8), r1.getSidesList());
	}

}
