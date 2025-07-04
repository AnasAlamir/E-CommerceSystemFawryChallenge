public class ProductToShip implements IShippable {
    OrderDetails orderDetails;

    public ProductToShip(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String getName() {
        return orderDetails.getProduct().getName();
    }

    @Override
    public double getWeight() {
        return ((ShippableProduct)orderDetails.getProduct()).getWeight();
    }
}
