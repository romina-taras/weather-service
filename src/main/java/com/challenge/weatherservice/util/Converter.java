package com.challenge.weatherservice.util;

/**
 * Utility class.
 * @author Romina Taras
 */
public final class Converter {

	private Converter() {
	}

	public static double toFahrenheit(double celsius) {
		return celsius * (9.0 / 5.0) + 32;
	}

}
