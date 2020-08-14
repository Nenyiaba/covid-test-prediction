package com.covid.covidprediction;

import com.covid.covidprediction.service.PredictionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class CovidPredictionApplicationTests {

	@Autowired
	PredictionService predictionService;

	@Test
	void testPrediction() {
		String prediction = predictionService.predict("1,2,1,2,1,2,1,2,1,2");
		assertTrue(prediction.equals("1") || prediction.equals("2"));
	}

}
