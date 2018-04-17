package com.esolutions.trainings.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrintSolution {
	private static final Integer LOWER_LIMIT = 1900;
	private static final Integer UPPER_LIMIT = 2018;

	@Autowired
	private MatchesController matchesController;

	@Autowired
	private PlayersController playersController;


	@Test
	public void print_req1() {
		for (int year = LOWER_LIMIT; year <= UPPER_LIMIT; year++) {
			final MatchModel model = this.matchesController.matchOfYear(year);

			System.out.println(year + ", " + model.getDayOfYear() + ", " + model.getDate());
		}
	}

	@Test
	public void print_req2() {
		final List<String> lastNames = playersController.repeatedLastName().getLast_names();

		lastNames.forEach(System.out::println);
	}
}
