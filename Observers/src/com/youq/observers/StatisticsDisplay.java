package com.youq.observers;

public class StatisticsDisplay implements Observer, DisplayElement{

	private WeatherData weatherDate;
	private float temperatuer = -1;
	private float maxTemperature = 0;
	private float minTemperature = 0;
	private float avgTemperature = 0;
	 
	public StatisticsDisplay(WeatherData w){
		weatherDate = w;
		weatherDate.registerObserver(this);
	}
	
	@Override
	public void displayArgs() {
		System.out.println("--------Statistics--------");
		System.out.println(" MaxTemperature \t" + maxTemperature);
		System.out.println(" MinTemperature \t" + minTemperature);
		System.out.println(" AvgTemperature \t" + avgTemperature);
		System.out.println("-----------------------");
	}

	@Override
	public void update(Object o) {
		WeatherData w = (WeatherData) o;

		if(temperatuer == -1 && minTemperature == 0){
			maxTemperature = w.getTemperature();
			minTemperature = w.getTemperature();
		}
		temperatuer = w.getTemperature();
		
		if(maxTemperature < temperatuer){
			maxTemperature = temperatuer;
		}
		if(minTemperature > temperatuer){
			minTemperature = temperatuer;
		}
		
		avgTemperature = (maxTemperature + minTemperature) / 2;
		
		
		displayArgs();
	}

}
