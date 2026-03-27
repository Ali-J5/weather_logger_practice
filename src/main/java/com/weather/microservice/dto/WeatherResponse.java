package com.weather.microservice.dto;

public class WeatherResponse {
    private double latitude;
    private double longitude;
    private CurrentWeather current_weather;

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