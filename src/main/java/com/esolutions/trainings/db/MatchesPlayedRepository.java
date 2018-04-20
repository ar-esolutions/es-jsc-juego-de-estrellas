package com.esolutions.trainings.db;

import com.esolutions.trainings.domain.MatchesPlayed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchesPlayedRepository extends JpaRepository<MatchesPlayed, Integer> {
}
