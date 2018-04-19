package com.esolutions.trainings.ws;

import com.esolutions.trainings.db.PlayerRepository;
import com.esolutions.trainings.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class PlayersController {
	private final PlayerRepository repository;

	@Autowired
	public PlayersController(PlayerRepository repository) {
		this.repository = repository;
	}


	@GetMapping(path = "/players/last-name/repeated")
	public RepeatedLastNameModel repeatedLastName() {
		final Map<String, Long> result = this.repository.findAll()
				.stream()
				.map(Player::getName)
				.map(PlayersController::lastName)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		final List<String> repeatedLastNames = result.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		RepeatedLastNameModel model = new RepeatedLastNameModel();
		model.setLast_names(repeatedLastNames);

		return model;
	}

	private static String lastName(String fullName) {
		return fullName.substring(0, fullName.indexOf(',')).trim();
	}
}
