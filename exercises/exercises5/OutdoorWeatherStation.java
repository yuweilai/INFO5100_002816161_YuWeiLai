package exercises.exercises5;

class OutdoorWeatherStation extends WeatherStation implements WeatherState {
    @Override
    public void performAction() {
        System.out.println("Outdoor Weather Station: Monitoring outdoor temperature.");
    }
}
