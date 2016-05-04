package com.youq.observers;

public class WeatherStation {

	public static void main(String[] args){
		WeatherData w = new WeatherData();
		
		CurrentConditionDisplay d = new CurrentConditionDisplay(w);
		
		//let the weather change
		w.setMeasurements(30, 65, 4f);
		w.setMeasurements(25, 65, 4f);
	}
}
