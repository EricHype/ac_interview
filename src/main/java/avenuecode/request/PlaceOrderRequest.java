package avenuecode.request;

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

}
