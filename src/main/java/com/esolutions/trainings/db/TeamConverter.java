package com.esolutions.trainings.db;

import com.esolutions.trainings.domain.Team;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class TeamConverter implements AttributeConverter<Team, String> {

	@Override
	public String convertToDatabaseColumn(Team attribute) {
		return Optional.ofNullable(attribute).map(Team::getFullName).orElse(null);
	}

	@Override
	public Team convertToEntityAttribute(String dbData) {
		return Optional.ofNullable(dbData).map(Team::fromFullName).orElse(null);
	}
}
