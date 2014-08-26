package com.abc.invmgmt.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.abc.invmgmt.OnlineStore;

public class TimeTakenTest {

	private static long startTime = System.nanoTime();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		OnlineStore.main(null);
		long endTime = System.nanoTime();
		System.out.println("It took " + (endTime - startTime)
				+ " Nano seconds i.e. " + ((endTime - startTime) / 1000000)
				+ " Milli Seconds");

	}

}
