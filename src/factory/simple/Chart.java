package factory.simple;

// 抽象产品类
public interface Chart {
    public void display();

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
class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("create histogram chart");
    }
    @Override
    public void display() {
        System.out.println("show histogram chart");
    }
}
class LineChart implements Chart {
    public LineChart() {
        System.out.println("create line chart");
    }
    @Override
    public void display() {

        System.out.println("display line chart");
    }
}
class PieChart implements Chart {
    public PieChart() {
        System.out.println("create pie chart");
    }
    @Override
    public void display() {
        System.out.println("display pie chart");

    }
}

class Client {
    public static void main(String[] args) {
        Chart chart;
        chart = Chart.getChart("histogram");
        chart.display();

        chart = Chart.getChart("pie");
        chart.display();
    }
}
