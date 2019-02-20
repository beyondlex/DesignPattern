package factory.simple.concept;

public class Client {
    public static void main(String[] args) {
        Product product;
        product = Factory.getProduct("a");
        //product = Factory.getProduct("b");
        product.methodName();
        product.methodDiff();
    }
}
