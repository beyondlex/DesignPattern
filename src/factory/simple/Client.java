package factory.simple;

public class Client {
    public static void main(String[] args) {
        Chart chart;
        chart = Chart.getChart("histogram");
        chart.display();

        chart = Chart.getChart("pie");
        chart.display();
    }
}
