//package com.nandan.observer;
import com.nandan.observer.CurrentConditionDisplay;
import com.nandan.observer.WeatherData;

public class WeatherStation
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,60,25.9f);
        weatherData.setMeasurements(78,62,28.5f);
    }
}