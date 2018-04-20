package com.esolutions.trainings.domain;

import org.springframework.util.Assert;

public enum Team {
	AME("Estrellas de America"),
	EU("Estrellas de Europa");

	private final String fullName;

	Team(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public static Team fromFullName(String fullName) {
		Assert.notNull(fullName, "'fullName' cannot be null");

		if (AME.fullName.equals(fullName)) return AME;
		if (EU.fullName.equals(fullName)) return EU;

		return null;
	}
}
