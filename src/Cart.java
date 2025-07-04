import java.util.*;

public class Cart
{
    private List<OrderDetails> orderDetailsList;
    public Cart() {
        this.orderDetailsList = new ArrayList<OrderDetails>();
    }
    boolean add(Product product, int quantity) throws RuntimeException {
        if(product.getAvailableQuantity() >= quantity)
        {
            product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
            OrderDetails orderDetails =new OrderDetails(product, quantity);
            orderDetailsList.add(orderDetails);
            return true;
        }
        throw new RuntimeException("product is out of stock or expired.");
    }
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

}
