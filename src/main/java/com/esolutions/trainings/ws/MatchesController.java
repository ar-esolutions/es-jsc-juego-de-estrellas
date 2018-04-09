package com.esolutions.trainings.ws;

import com.esolutions.trainings.db.MatchRepository;
import com.esolutions.trainings.domain.Match;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
@Api(value = "Matches Resource")
public class MatchesController {

	private static final int TRANSITION_YEAR = 1950;
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	private final MatchRepository matchRepository;

	@Autowired
	public MatchesController(MatchRepository matchRepository) {
		this.matchRepository = matchRepository;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(path = "/matches/{year}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca un partido por año (sólo hay uno por año)", response = MatchModel.class)
	public MatchModel matchOfYear(@PathVariable Integer year) {
		Match aMatch = this.matchRepository.findOne(year);

		MatchModel matchModel = new MatchModel();
		matchModel.setYear(year);
		matchModel.setDayOfYear(aMatch.getDayOfYear());
		matchModel.setDate(solve(matchModel.getYear(), matchModel.getDayOfYear()));

		return matchModel;
	}

	String solve(int year, int day){
		boolean isLeapYear = false;
		if (year >= 1930 && year <= 2018) {
			if (year > TRANSITION_YEAR) {
				isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
				return FORMAT.format(calculateDate(year, day, isLeapYear));
			} else if (year < TRANSITION_YEAR) {
				isLeapYear = year % 4 == 0;
				return FORMAT.format(calculateDate(year, day, isLeapYear));
			} else {
				return FORMAT.format(calculateDate(year, day, isLeapYear));
			}
		} else {
			return "Year out of range";
		}
	}

	Date calculateDate(int year, int day, boolean isLeapYear) {
		int sumatoria = 0;
		int month = 1;

		for (month = 1; month <= 12; month ++) {
			int dias = getDaysInMonth(month);

			if (isLeapYear && month == 2) {
				dias += 1;
			}

			if (sumatoria + dias < day) {
				sumatoria += dias;
			} else {
				break;
			}
		}

		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.set(GregorianCalendar.YEAR, year);
		cal.set(GregorianCalendar.MONTH, month -1);
		cal.set(GregorianCalendar.DAY_OF_MONTH, day - sumatoria);

		// In 1950, February started on the 14th
		if (year == TRANSITION_YEAR && day > 31) {
			cal.add(GregorianCalendar.DAY_OF_YEAR, 13);
		}

		return cal.getTime();
	}

	int getDaysInMonth(int month) {
		int days = 0;

		if (month < 8) {
			if (month % 2 == 0) {
				days = (month == 2) ? 28 : 30;
			} else {
				days = 31;
			}
		} else {
			if (month % 2 == 0) {
				days = 31;
			} else {
				days = 30;
			}
		}

		return days;
	}

}
