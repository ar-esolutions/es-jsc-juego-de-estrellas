package com.esolutions.trainings.ws;

import com.esolutions.trainings.db.MatchesPlayedRepository;
import com.esolutions.trainings.db.PlayerRepository;
import com.esolutions.trainings.domain.MatchesPlayed;
import com.esolutions.trainings.domain.Player;
import com.esolutions.trainings.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RestController
public class PlayersController {
	private final PlayerRepository repository;
	private final MatchesPlayedRepository matchesPlayedRepository;

	@Autowired
	public PlayersController(PlayerRepository repository, MatchesPlayedRepository matchesPlayedRepository) {
		this.repository = repository;
		this.matchesPlayedRepository = matchesPlayedRepository;
	}


	@GetMapping(path = "/players/last-name/repeated")
	public RepeatedLastNameModel repeatedLastName() {
		final Map<String, Long> result = this.repository.findAll()
				.stream()
				.map(Player::getName)
				.map(PlayersController::lastName)
				.collect(groupingBy(Function.identity(), counting()));

		final List<String> repeatedLastNames = result.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(toList());

		RepeatedLastNameModel model = new RepeatedLastNameModel();
		model.setLast_names(repeatedLastNames);

		return model;
	}

	@GetMapping(path = "/players/ranking")
	public RankingModel ranking() {
		final Map<Team, Map<Player, Long>> matchesPlayedByPlayerByTeam = this.matchesPlayedRepository.findAll()
				.stream()
				.collect(groupingBy(
						MatchesPlayed::getTeam,
						groupingBy(MatchesPlayed::getPlayer, counting())
				));


		RankingModel model = new RankingModel();

		final Map<Player, Long> matchesOfAmerica = matchesPlayedByPlayerByTeam.get(Team.AME);
		model.setEstrellas_de_america(buildModelFrom(matchesOfAmerica));
		final Map<Player, Long> matchesOfEuropa = matchesPlayedByPlayerByTeam.get(Team.EU);
		model.setEstrellas_de_europa(buildModelFrom(matchesOfEuropa));

		return model;
	}

	private static TeamModel buildModelFrom(Map<Player, Long> matchesByPlayer) {
		return matchesByPlayer.entrySet()
					.stream()
					.sorted(Comparator.comparingLong(Map.Entry::getValue))
					.map(entry -> {
						final PlayerModel playerModel = new PlayerModel();
						playerModel.setName(entry.getKey().getName());
						playerModel.setPlayed(entry.getValue());
						return playerModel;
					})
					.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
						final TeamModel teamModel = new TeamModel();
						teamModel.setPlayers(list);
						return teamModel;
					}));
	}

	private static <T> Collector<T, ?, List<T>> toSortedList(Comparator<T> sorterKey) {
		return collectingAndThen(toList(), list -> list.stream().sorted(sorterKey).collect(toList()));
	}

	private static String lastName(String fullName) {
		return fullName.substring(0, fullName.indexOf(',')).trim();
	}
}
