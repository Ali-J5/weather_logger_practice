package com.weather.microservice.dto;

// DTO to catch the JSON response from the Open-Meteo API.
public class WeatherResponse {

    // Primitive fields matching the exact JSON keys for Jackson mapping.
    private double latitude;
    private double longitude;

    // Custom object to catch the nested "current_weather" JSON block.
    private CurrentWeather current_weather;

    // Required Getters and Setters for Spring Boot/Jackson to populate the data.

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public CurrentWeather getCurrentWeather() {
        return current_weather;
    }

    public void setCurrentWeather(CurrentWeather current_weather) {
        this.current_weather = current_weather;
    }

    // Static nested class mirroring the tructure of the nested JSON object.
    public static class CurrentWeather {
        private double temperature;
        private double windspeed;
        private double weathercode;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getWindspeed() {
            return windspeed;
        }

        public void setWindspeed(double windspeed) {
            this.windspeed = windspeed;
        }

        public double getWeathercode() {
            return weathercode;
        }

        public void setWeathercode(double weathercode) {
            this.weathercode = weathercode;
        }
    }
}