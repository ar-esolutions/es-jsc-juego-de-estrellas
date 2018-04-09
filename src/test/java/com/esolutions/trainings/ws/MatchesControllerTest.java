package com.esolutions.trainings.ws;

import org.junit.Assert;
import org.junit.Test;

public class MatchesControllerTest {
	
	@Test
	public void test_solve_Gregorian_Leap() {
		MatchesController controller = new MatchesController(null);
		String date = controller.solve(2016, 256);
		Assert.assertEquals("12-09-2016", date);
	}
	
	@Test
	public void test_solve_Gregorian_NotLeap() {
		MatchesController controller = new MatchesController(null);
		String date = controller.solve(2017, 256);
		Assert.assertEquals("13-09-2017", date);
	}
	
	@Test
	public void test_solve_Julian_Leap() {
		MatchesController controller = new MatchesController(null);
		String date = controller.solve(1948, 256);
		Assert.assertEquals("12-09-1948", date);
	}
	
	@Test
	public void test_solve_Julian_NotLeap() {
		MatchesController controller = new MatchesController(null);
		String date = controller.solve(1947, 256);
		Assert.assertEquals("13-09-1947", date);
	}
	
	@Test
	public void test_solve_Transition_Leap() {
		MatchesController controller = new MatchesController(null);
		String date = controller.solve(1950, 256);
		Assert.assertEquals("26-09-1950", date);
	}
}
