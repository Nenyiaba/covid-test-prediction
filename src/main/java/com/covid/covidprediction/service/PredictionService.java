package com.covid.covidprediction.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class PredictionService {

	public String predict(String testString){
		return performPredictionWithR(testString);
	}

	private String performPredictionWithR(String testString){
		try
		{
			Runtime runtime = Runtime.getRuntime();
			String command = "RScript test.R " + testString;
			Process process = runtime.exec(command);
			BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line = r.readLine();
			if(line == null){
				r = new BufferedReader(new InputStreamReader(process.getInputStream()));
				line = r.readLine();
			}
			while (line != null) {
				if(line.contains("PREDICTION RESULT===")){
					String result = line.split("PREDICTION RESULT===")[1];
					result = result.replace("\"","");
					return result;
				}
				line = r.readLine();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
}
