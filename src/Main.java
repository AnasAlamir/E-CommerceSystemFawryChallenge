public class Main {
    public static void main(String[] args) {
        Cart cart1 = new Cart();

        Customer customer1 = new Customer("anas",10000, cart1);

        ShippableProduct cheese = new ShippableProduct("cheese",20,100,true,122,0.2);
        NonShippableProduct mobileScratch = new NonShippableProduct("mobile scratch",4,1500,false);

        customer1.addPoductToCart(cheese,2);
        customer1.addPoductToCart(mobileScratch,1);

        Order order1 = new Order(customer1,customer1.getCart());
        order1.checkout();
    }

}