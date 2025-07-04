public class Order {
    Customer customer;
    Cart cart;
//    private double orderSubTotal;
    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }
    void checkout(){
        if(cart.getProducts().isEmpty())
            throw new RuntimeException("Cart is empty.");
        if(!(customer.getBalance() >= getPaidAmount()))
            throw new RuntimeException("Customer's balance is insufficient.");
        customer.setBalance(customer.getBalance() - getPaidAmount());
        printCheckoutDetails();
    }
    void printCheckoutDetails()
    {
        System.out.println("CONSOLE OUTPUT");
        System.out.println("** Shipment notice **");
        for(var product : cart.getProducts())
        {
            if(product.getProduct() instanceof ShippableProduct)
                System.out.println(product.getQuantity() + "x " + product.getProduct().getName() + "\t" + ((ShippableProduct) product.getProduct()).getWeight() + "g");
        }
        System.out.println("Total package weight " + totalPackageWeightInKilos() + "kg");
        System.out.println();
        System.out.println("** Checkout receipt **");
        for(var product : cart.getProducts())
        {
            System.out.println(product.getQuantity() + "x" + product.getProduct().getName() + "\t" + product.getProduct().getPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + getOrderSubTotal());
        System.out.println("Shipping\t" + getShippingFees());
        System.out.println("Amount\t" + getPaidAmount());
    }
    private double totalPackageWeightInKilos() {
        double totalPackageWeight = 0;
        for(var product : cart.getProducts())
        {
            totalPackageWeight += ((ShippableProduct) product.getProduct()).getWeight() * product.getQuantity();
        }
        return totalPackageWeight / 1000;
    }

    private double getOrderSubTotal() {
        double orderSubTotal = 0;
        for(var product : cart.getProducts())
        {
            orderSubTotal += product.getQuantity() * product.getProduct().getPrice();
        }
        return orderSubTotal;
    }
    private double getShippingFees() {
        double shippingFees = 0;
        for(var product : cart.getProducts())
        {
            if(product.getProduct() instanceof ShippableProduct)
                shippingFees += ((ShippableProduct) product.getProduct()).getShippingFeesPerGram() * ((ShippableProduct) product.getProduct()).getWeight() * product.getQuantity();
        }
        return shippingFees;
    }
    private double getPaidAmount() {

        return getOrderSubTotal() + getShippingFees();
    }
}
