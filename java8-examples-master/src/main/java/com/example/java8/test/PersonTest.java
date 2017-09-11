package com.example.java8.test;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class PersonTest {

	@Test
	public void testSetFirstName()
	{
		Person p = new Person();
		p.setFirstName("liu");
		assertEquals("liu", p.getFirstName());
	}
}
