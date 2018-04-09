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

@RestController
@Api(value = "Matches Resource")
public class MatchesController {
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

		return matchModel;
	}
}
