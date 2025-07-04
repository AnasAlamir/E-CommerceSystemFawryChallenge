public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Product cheese = new Product();
        customer1.addPoductToCart(cheese,2);
        checkout(customer1,customer1.getCart());
    }
//    static void checkout(Customer customer, Cart cart){
//
//    }
}