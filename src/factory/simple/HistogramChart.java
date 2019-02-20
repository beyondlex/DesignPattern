package factory.simple;

public class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("create histogram chart");
    }
    @Override
    public void display() {
        System.out.println("show histogram chart");
    }
}
