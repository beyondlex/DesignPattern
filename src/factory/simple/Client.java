package factory.simple;

public class Client {
    public static void main(String[] args) {
        Chart chart;
        chart = ChartFactory.getChart("histogram");
        chart.display();

        chart = ChartFactory.getChart("pie");
        chart.display();
    }
}
