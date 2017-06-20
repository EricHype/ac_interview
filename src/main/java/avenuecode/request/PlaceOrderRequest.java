package avenuecode.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
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

    public PlaceOrderRequest(){
        lineItems = new ArrayList<>();
    }

    public PlaceOrderRequest(@JsonProperty("destination") String destination,
                             @JsonProperty("lineItems") List<OrderLineItemRequest> lineItems){
        this.destination = destination;
        this.lineItems = lineItems;
    }

    public static class OrderLineItemRequest{
        Integer productId;
        Integer amount;

        public OrderLineItemRequest() {}

        public OrderLineItemRequest(@JsonProperty("productId") Integer productId,
                                    @JsonProperty("amount") Integer amount){
            this.productId = productId;
            this.amount = amount;
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
}
