public class Customer {
    private String name;
    private double balance;
    private Cart cart;
    public Customer(String name,double balance, Cart cart) {
        this.balance = balance;
        this.name = name;
        this.cart = cart;
    }
    public void addPoductToCart(Product product, int quantity){
        try {
            cart.add(product, quantity);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
