package com.esolutions.trainings.db;

import com.esolutions.trainings.logic.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {
}
