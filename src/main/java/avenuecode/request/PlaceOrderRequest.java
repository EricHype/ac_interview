package avenuecode.request;

import java.util.List;

/**
 * Created by eheitmuller on 6/18/17.
 */
public class PlaceOrderRequest {
    String destination;
    List<OrderLineItemRequest> lineItems;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<OrderLineItemRequest> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<OrderLineItemRequest> lineItems) {
        this.lineItems = lineItems;
    }

    public static class OrderLineItemRequest{
        Integer productId;
        Integer amount;

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
}
