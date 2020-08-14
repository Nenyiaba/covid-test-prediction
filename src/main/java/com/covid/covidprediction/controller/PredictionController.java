package com.covid.covidprediction.controller;

import com.covid.covidprediction.model.PredictionRequest;
import com.covid.covidprediction.model.PredictionResponse;
import com.covid.covidprediction.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PredictionController {
	@Autowired
	PredictionService predictionService;

	@PostMapping("predict")
	public PredictionResponse predict(@RequestBody PredictionRequest predictionRequest){
		PredictionResponse predictionResponse = new PredictionResponse();
		String response = predictionService.predict(predictionRequest.toString());
		predictionResponse.setPrediction(response);
		return predictionResponse;
	}
}
