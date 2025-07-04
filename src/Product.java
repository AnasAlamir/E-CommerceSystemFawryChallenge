public abstract class Product {
    private String name;
    private double price;
    private int availableQuantity;
    private boolean expire;
    public Product(String name, int quantity, double price, boolean expire) {
        this.name = name;
        this.expire = expire;
        this.availableQuantity = quantity;
        this.price = price;
    }
    public boolean isExpired()
    {
        return expire;
    }
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
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
