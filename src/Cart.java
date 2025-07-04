public class Cart
{
    boolean add(Product product, int quantity) throws IllegalAccessException {
        if(product.getQuantity() >= quantity)
        {
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
        throw new IllegalAccessException("product is out of stock or expired.");
    }

}
