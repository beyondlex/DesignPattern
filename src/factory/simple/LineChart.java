package factory.simple;

public class LineChart implements Chart {
    public LineChart() {
        System.out.println("create line chart");
    }
    @Override
    public void display() {

        System.out.println("display line chart");
    }
}
