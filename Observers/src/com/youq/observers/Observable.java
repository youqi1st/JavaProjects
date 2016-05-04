package com.youq.observers;

public interface Observable {
	public void registerObserver (Observer o);
	public void unRegisterObserver (Observer o);
	public void notifyObservers();
}
