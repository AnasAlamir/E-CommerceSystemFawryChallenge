import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    private List<IShippable> shippableProducts;

    public ShippingService() {
        this.shippableProducts = new ArrayList<IShippable>();
    }
    public void addProductsToShippingService(List<IShippable> shippableProducts)
    {
        shippableProducts.addAll(shippableProducts);
    }
    public List<IShippable> getShippableProducts() {
        return shippableProducts;
    }

    public void setShippableProducts(List<IShippable> shippableProducts) {
        this.shippableProducts = shippableProducts;
    }


}
