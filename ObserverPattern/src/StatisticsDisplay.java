public class StatisticsDisplay implements Observer, DisplayElement {

    private double maxTemp;
    private double minTemp;
    private double tempSum;
    private int tempCount;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.maxTemp = Integer.MIN_VALUE;
        this.minTemp = Integer.MAX_VALUE;
        this.tempCount = 0;
        this.tempSum = 0;
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Avg/Max/Min Temperature: %.1f/%.1f/%.1f\n", tempSum/tempCount, maxTemp, minTemp);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        this.maxTemp = Math.max(this.maxTemp, temp);
        this.minTemp = Math.min(this.minTemp, temp);
        this.tempSum += temp;
        this.tempCount++;
        display();
    }

}
