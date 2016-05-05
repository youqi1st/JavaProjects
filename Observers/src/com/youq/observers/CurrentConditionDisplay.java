package com.youq.observers;

public class CurrentConditionDisplay implements Observer, DisplayElement{

	private float temperature;
	private float humidity;
	private float pressure;
	private WeatherData weatherData;
	
	public CurrentConditionDisplay(WeatherData w){
		weatherData = w;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(Object o) {
		WeatherData w = (WeatherData) o;
		temperature = w.getTemperature();
		humidity = w.getHumidity();
		pressure = w.getPressure();
		
		displayArgs();
	}

	@Override
	public void displayArgs() {
		System.out.println("--------Current--------");
		System.out.println(" Temperature \t" + temperature);
		System.out.println(" Humidity \t" + humidity);
		System.out.println(" Pressure \t" + pressure);
		System.out.println("-----------------------");
	}

	
}
