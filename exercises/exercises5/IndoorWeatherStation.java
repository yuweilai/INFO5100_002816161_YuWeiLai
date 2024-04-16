package exercises.exercises5;

class IndoorWeatherStation extends WeatherStation implements WeatherState {
    @Override
    public void performAction() {
        System.out.println("Indoor Weather Station: Monitoring indoor temperature.");
    }
}
