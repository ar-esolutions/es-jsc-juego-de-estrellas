package com.esolutions.trainings.ws;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Match")
public class MatchModel {
	private Integer year;
	private Integer dayOfYear;
	private String date;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
