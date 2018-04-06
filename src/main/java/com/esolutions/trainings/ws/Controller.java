package com.esolutions.trainings.ws;

import com.esolutions.trainings.db.MatchRepository;
import com.esolutions.trainings.logic.Match;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private final MatchRepository matchRepository;

	@Autowired
	public Controller(MatchRepository matchRepository) {
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

		return matchModel;
	}
}
