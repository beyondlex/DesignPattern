package strategy.v2;

public class MovieTicket {
    private double price;
    private Discount discount;

    public double getPrice() {
        return this.discount.calculate(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}

interface Discount {
    public double calculate(double price);
}

class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("student ticket:");
        return price * 0.8;
    }
}

class ChildrenDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("children ticket:");
        return price - 10;
    }
}

class VipDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("vip ticket:");
        System.out.println("point increase.");
        return price * 0.5;
    }
}

class BadmanDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("bad man ticket: ");
        return price * 1.5;
    }
}

class Client {

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        double originalPrice = 60.0;

        ticket.setPrice(originalPrice);

        System.out.println("original price: " + originalPrice);

        ticket.setDiscount(new ChildrenDiscount());
        System.out.println("children price: " + ticket.getPrice());

        ticket.setDiscount(new StudentDiscount());
        System.out.println("student price: " + ticket.getPrice());

        ticket.setDiscount(new VipDiscount());
        System.out.println("vip price: " + ticket.getPrice());

        ticket.setDiscount(new BadmanDiscount());
        System.out.println("bad man price: " + ticket.getPrice());
    }
}
