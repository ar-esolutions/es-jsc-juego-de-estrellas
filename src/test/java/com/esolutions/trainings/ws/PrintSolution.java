package com.esolutions.trainings.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrintSolution {
	private static final Integer[] LIMITS = {1900, 2018};

	@Autowired
	private MatchesController controller;


	@Test
	public void print_solution() {
		for (int year = LIMITS[0]; year <= LIMITS[1]; year++) {
			final MatchModel model = this.controller.matchOfYear(year);

			System.out.println(year + ", " + model.getDayOfYear() + ", " + model.getDate());
		}
	}
}
