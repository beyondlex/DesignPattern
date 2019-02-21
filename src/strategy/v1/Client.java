package strategy.v1;

class MovieTicket {
    private double price;
    private String type;

    public double getPrice() {
        return this.calculate();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double calculate() {
        if (this.type.equalsIgnoreCase("student")) {
            System.out.println("student ticket:");
            return price * 0.8;
        } else if (this.type.equalsIgnoreCase("children") && this.price >= 20) {
            System.out.println("children ticket:");
            return price - 10;
        } else if (this.type.equalsIgnoreCase("vip")) {
            System.out.println("vip ticket:");
            System.out.println("point increase.");
            return price * 0.5;
        } else {
            return price;
        }

        /*
        (1) MovieTicket类的calculate()方法非常庞大，它包含各种打折算法的实现代码，在代码中出现了较长的if…else…语句，不利于测试和维护。

        (2) 增加新的打折算法或者对原有打折算法进行修改时必须修改MovieTicket类的源代码，违反了“开闭原则”，系统的灵活性和可扩展性较差。

        (3) 算法的复用性差，如果在另一个系统（如商场销售管理系统）中需要重用某些打折算法，只能通过对源代码进行复制粘贴来重用，无法单独重用其中的某个或某些算法（重用较为麻烦）。

        我们需要对MovieTicket类进行重构，将原本庞大的MovieTicket类的职责进行分解，将算法的定义和使用分离，这就是策略模式所要解决的问题
         */
    }
}

public class Client {

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        double originalPrice = 60.0;

        ticket.setPrice(originalPrice);

        System.out.println("original price: " + originalPrice);

        ticket.setType("children");
        System.out.println("children price: " + ticket.getPrice());

        ticket.setType("student");
        System.out.println("student price: " + ticket.getPrice());

        ticket.setType("vip");
        System.out.println("vip price: " + ticket.getPrice());
    }
}
