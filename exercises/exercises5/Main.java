package exercises.exercises5;

public class Main {
    public static void main(String[] args) {
        // Observer Pattern
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneApp());

        // Factory Pattern
        IndoorWeatherStation indoorStation = WeatherStationFactory.createIndoorWeatherStation();
        OutdoorWeatherStation outdoorStation = WeatherStationFactory.createOutdoorWeatherStation();

        // State Pattern
        indoorStation.performAction();
        outdoorStation.performAction();

        // Simulate temperature changes
        station.setTemperature(20);
        station.setTemperature(25);
    } 
}