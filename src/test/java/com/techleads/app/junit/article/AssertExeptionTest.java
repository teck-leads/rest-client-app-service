package com.techleads.app.junit.article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
public class AssertExeptionTest {
	
	@Test
	public void willThrowThrows() throws Exception {
		assertThrows(IOException.class,()->{
			willThrow();
		});
		
	}
	@Test
//	@Timeout(value = 100L, unit = TimeUnit.NANOSECONDS)
//	 @Timeout(5)
	public void testThingsThatMayRunForever() {
//		assertEquals(42, someLogRoutine());
		
		 assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			 someLogRoutine();
		    });
	}
	
	private static void willThrow() throws IOException {
		throw new IOException("IO exception");
	}
	
	private static int someLogRoutine() {
		while(true) {
			//it will take forever
		}
	}

}
