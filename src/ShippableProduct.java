public class ShippableProduct extends Product implements IShippable{
    private double weight;
    private double shippingFeesPerGram;

    public ShippableProduct(String name, int quantity, double price, boolean expire,double weight, double shippingFeesPerGram) {
        super(name, quantity, price, expire);
        this.weight =weight;
        this.shippingFeesPerGram = shippingFeesPerGram;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getShippingFeesPerGram() {
        return shippingFeesPerGram;
    }

    public void setShippingFeesPerGram(double shippingFeesPerGram) {
        this.shippingFeesPerGram = shippingFeesPerGram;
    }
}
