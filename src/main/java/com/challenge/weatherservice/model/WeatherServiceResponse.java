package com.challenge.weatherservice.model;

/**
 * POJO.
 * @author Romina Taras
 */
public class WeatherServiceResponse {

	private String cityName;
	private double degreesCelsius;
	private double degreesFahrenheit;

	public WeatherServiceResponse() {
	}

	public WeatherServiceResponse(String cityName, double degreesCelsius, double degreesFahrenheit) {
		this.cityName = cityName;
		this.degreesCelsius = degreesCelsius;
		this.degreesFahrenheit = degreesFahrenheit;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getDegreesCelsius() {
		return degreesCelsius;
	}

	public void setDegreesCelsius(double degreesCelsius) {
		this.degreesCelsius = degreesCelsius;
	}

	public double getDegreesFahrenheit() {
		return degreesFahrenheit;
	}

	public void setDegreesFahrenheit(double degreesFahrenheit) {
		this.degreesFahrenheit = degreesFahrenheit;
	}

}
