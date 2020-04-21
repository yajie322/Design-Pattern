import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    private double maxTemp;
    private double minTemp;
    private double tempSum;
    private int tempCount;
    private Observable observable;

    public StatisticsDisplay(Observable observable) {
        this.maxTemp = Integer.MIN_VALUE;
        this.minTemp = Integer.MAX_VALUE;
        this.tempCount = 0;
        this.tempSum = 0;
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Avg/Max/Min Temperature: %.1f/%.1f/%.1f\n", tempSum/tempCount, maxTemp, minTemp);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            double temp = weatherData.getTemperature();
            this.maxTemp = Math.max(this.maxTemp, temp);
            this.minTemp = Math.min(this.minTemp, temp);
            this.tempSum += temp;
            this.tempCount++;
            display();
        }
    }
}
