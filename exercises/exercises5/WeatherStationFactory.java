package exercises.exercises5;

class WeatherStationFactory {
    public static IndoorWeatherStation createIndoorWeatherStation() {
        return new IndoorWeatherStation();
    }

    public static OutdoorWeatherStation createOutdoorWeatherStation() {
        return new OutdoorWeatherStation();
    }
}
