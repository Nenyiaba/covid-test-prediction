package com.covid.covidprediction.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredictionRequest {
	private String pneumonia;
	private String diabetes;
	private String breathingDifficulty;
	private String asthma;
	private String hypertensive;
	private String otherCommunicableDisease;
	private String stroke;
	private String obese;
	private String kidneyFailure;
	private String smoker;

	@Override
	public String toString() {
		String s = pneumonia+","+diabetes+","+breathingDifficulty+","+asthma+","+hypertensive+","
				+otherCommunicableDisease+","+stroke+","+obese+","+kidneyFailure+","+smoker;
		return s;
	}
}
