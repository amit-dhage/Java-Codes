package com.abc.invmgmt.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.abc.invmgmt.OnlineStore;

public class MemoryTest {

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Runtime runtime = Runtime.getRuntime();
		OnlineStore.main(null);
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory in bytes: " + memory + " i.e. "
				+ bytesToMegabytes(memory) + " Mega bytes");
	}

}
