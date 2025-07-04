public class ShippableProduct extends Product implements IShippable{
    private double weight;
    private double shippingFees;

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
    public double getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }
}
