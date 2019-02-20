package factory.simple;

public class ChartFactory {
    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("histogram chart init");
        } else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("pie chart init");
        } else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("line chart init");
        }
        return chart;
    }
}
