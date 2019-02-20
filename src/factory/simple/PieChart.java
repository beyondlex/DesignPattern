package factory.simple;

public class PieChart implements Chart {
    public PieChart() {
        System.out.println("create pie chart");
    }
    @Override
    public void display() {
        System.out.println("display pie chart");

    }
}
