package avenuecode.request;

/**
 * Created by eheitmuller on 6/19/17.
 */
public class OrderLineItemRequest {
    Integer productId;
    Integer amount;

    public OrderLineItemRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
