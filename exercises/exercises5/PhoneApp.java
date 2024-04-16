package exercises.exercises5;

class PhoneApp implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Phone App: Temperature is " + temperature + " degrees Celsius.");
    }
}