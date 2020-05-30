package com.challenge.weatherservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.challenge.weatherservice.model.WeatherServiceResponse;
import com.challenge.weatherservice.util.Converter;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Controller class.
 * @author Romina Taras
 */
@Controller
public class WeatherServiceController {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceController.class);

	private static final String URL_CITY_DATA = "https://www.metaweather.com/api/location/search/?query=";
	private static final String URL_WHEATHER_DATA = "https://www.metaweather.com/api/location/";

	@GetMapping("/weather")
	@ResponseBody
	public WeatherServiceResponse sayHello(
			@RequestParam(name = "city", required = false, defaultValue = "santiago") String city) {

		WeatherServiceResponse response = new WeatherServiceResponse();
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<JsonNode> cityData = restTemplate.getForEntity(URL_CITY_DATA + city, JsonNode.class);
		response.setCityName(cityData.getBody().get(0).get("title").textValue());
		LOG.info("City: " + response.getCityName());
		String woeid = cityData.getBody().get(0).get("woeid").toString();
		LOG.info("WOEID: " + woeid);

		ResponseEntity<JsonNode> weatherData = restTemplate.getForEntity(URL_WHEATHER_DATA + woeid, JsonNode.class);
		String temperature = weatherData.getBody().get("consolidated_weather").get(0).get("the_temp").toString();
		LOG.info("Temperature: " + temperature);

		response.setDegreesCelsius(Double.valueOf(temperature));
		response.setDegreesFahrenheit(Converter.toFahrenheit(response.getDegreesCelsius()));

		return response;

	}

}
