package com.youq.observers;

import java.util.ArrayList;

public class WeatherData implements Observable{

	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData(){
		observers = new ArrayList();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void unRegisterObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for(int i=0; i < observers.size(); i++){
			((Observer) observers.get(i)).update(this);
		}
		
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMeasurements(float t, float h, float p){
		setTemperature(t);
		setHumidity(h);
		setPressure(p);
	}

	
//auto added getter and setters
//--------------------
	
	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
//--------------------
//auto added getter and setters

}
