import java.util.*;

public class Cart
{
    private List<OrderDetails> productsOrderDetails;
    public Cart() {
        this.productsOrderDetails = new ArrayList<OrderDetails>();
    }
    boolean add(Product product, int quantity) throws RuntimeException {
        if(product.getQuantity() >= quantity)
        {
            product.setQuantity(product.getQuantity() - quantity);
            OrderDetails orderDetails = new OrderDetails(product, quantity);
            productsOrderDetails.add(orderDetails);
            return true;
        }
        throw new RuntimeException("product is out of stock or expired.");
    }
    public List<OrderDetails> getProducts() {
        return productsOrderDetails;
    }

    public void setProductsOrderDetails(List<OrderDetails> productsOrderDetails) {
        this.productsOrderDetails = productsOrderDetails;
    }

}
