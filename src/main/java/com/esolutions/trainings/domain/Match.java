package com.esolutions.trainings.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "matches")
@Entity
public class Match {
	@Id
	@Column(name = "year")
	private Integer year;

	@Column(name = "day_of_year", nullable = false)
	private Integer dayOfYear;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(Integer dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
}
