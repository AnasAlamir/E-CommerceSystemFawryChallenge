public class Customer {
    private double balance;
    private Cart cart;

    public void addPoductToCart(Product product, int quantity){
        try {
            cart.add(product, quantity);
        } catch (IllegalAccessException e) {
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
}
