package com.esolutions.trainings.db;

import com.esolutions.trainings.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
