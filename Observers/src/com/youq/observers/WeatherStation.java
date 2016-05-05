package com.youq.observers;

public class WeatherStation {

	public static void main(String[] args){
		WeatherData w = new WeatherData();
		
		CurrentConditionDisplay d = new CurrentConditionDisplay(w);
		StatisticsDisplay s = new StatisticsDisplay(w);
		
		System.out.println("This is a Weather Station!");
		
		//let the weather change
		w.setMeasurements(30, 65, 4f);
		w.setMeasurements(25, 65, 4f);
		w.setMeasurements(0, 60, 3f);

	}
}
