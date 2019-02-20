package factory.simple.concept;

public class Factory {

    // static factory method:
    public static Product getProduct(String arg) {

        Product product = null;
        if (arg.equalsIgnoreCase("a")) {
            product = new ConcreteProductA();
        }
        else if (arg.equalsIgnoreCase("b")) {
            product = new ConcreteProductB();
        }
        return product;
    }
}
