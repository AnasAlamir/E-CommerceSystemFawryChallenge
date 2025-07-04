public abstract class Product {
    private String name;
    private double price;

    public Product(String name, int quantity, double price, boolean expire) {
        this.name = name;
        this.expire = expire;
        this.quantity = quantity;
        this.price = price;
    }

    private int quantity;
    private boolean expire;

    public boolean isExpired()
    {
        return expire;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
