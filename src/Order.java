import java.util.ArrayList;
import java.util.List;

public class Order {
    Customer customer;
    Cart cart;
    ShippingService shippingService;
    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        shippingService = new ShippingService();
    }
    void checkout() throws RuntimeException {
        if(cart.getOrderDetailsList().isEmpty())
            throw new RuntimeException("Cart is empty.");
        if(!(customer.getBalance() >= getPaidAmount()))
            throw new RuntimeException("Customer's balance is insufficient.");
        customer.setBalance(customer.getBalance() - getPaidAmount());
        printCheckoutDetails();
        shippingService.addProductsToShippingService(getShippableProducts());
    }
    public List<IShippable> getShippableProducts()
    {
        List<IShippable> shippableList = new ArrayList<>();
        for(var orderDetails : cart.getOrderDetailsList())
        {
            if(orderDetails.getProduct() instanceof ShippableProduct){
                ProductToShip productToShip = new ProductToShip(orderDetails);
                shippableList.add(productToShip);
            }
        }
        return shippableList;
    }
    void printCheckoutDetails()
    {
        System.out.println("** Shipment notice **");
        for(var orderDetails : cart.getOrderDetailsList())
        {
            if(orderDetails.getProduct() instanceof ShippableProduct)
                System.out.println(orderDetails.getQuantity() + "x " + orderDetails.getProduct().getName() + "\t\t\t" + ((ShippableProduct) orderDetails.getProduct()).getWeight() * orderDetails.getQuantity() + "g");
        }
        System.out.println("Total package weight " + totalPackageWeightInKilos() + "kg");
        System.out.println();
        System.out.println("** Checkout receipt **");
        for(var orderDetails : cart.getOrderDetailsList())
        {
            System.out.println(orderDetails.getQuantity() + "x " + orderDetails.getProduct().getName() + "\t\t\t" + orderDetails.getProduct().getPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + getOrderSubTotal());
        System.out.println("Shipping\t" + getShippingFees());
        System.out.println("Amount\t" + getPaidAmount() + "$");
        System.out.println("----------------------");
        System.out.println("** customer current balance after payment **");
        System.out.println("Balance\t"+ customer.getBalance() + "$");
    }
    private double totalPackageWeightInKilos() {
        double totalPackageWeight = 0;
        for(var orderDetails : cart.getOrderDetailsList())
        {
            if(orderDetails.getProduct() instanceof ShippableProduct)
                totalPackageWeight += ((ShippableProduct) orderDetails.getProduct()).getWeight() * orderDetails.getQuantity();
        }
        return totalPackageWeight / 1000;
    }

    private double getOrderSubTotal() {
        double orderSubTotal = 0;
        for(var orderDetails : cart.getOrderDetailsList())
        {
            orderSubTotal += orderDetails.getQuantity() * orderDetails.getProduct().getPrice();
        }
        return orderSubTotal;
    }
    private double getShippingFees() {
        double shippingFees = 0;
        for(var orderDetails : cart.getOrderDetailsList())
        {
            if(orderDetails.getProduct() instanceof ShippableProduct)
                shippingFees += ((ShippableProduct) orderDetails.getProduct()).getShippingFeesPerGram() * ((ShippableProduct) orderDetails.getProduct()).getWeight() * orderDetails.getQuantity();
        }
        return shippingFees;
    }
    private double getPaidAmount() {

        return getOrderSubTotal() + getShippingFees();
    }
}
