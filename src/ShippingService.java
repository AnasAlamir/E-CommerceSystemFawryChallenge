import java.util.List;

public class ShippingService {
    public ShippingService(List<IShippable> shippableList) {
        this.shippableList = shippableList;
    }

    private List<IShippable> shippableList;

}
