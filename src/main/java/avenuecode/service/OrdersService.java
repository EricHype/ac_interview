package avenuecode.service;

import avenuecode.model.Order;
import avenuecode.model.OrderLineItem;
import avenuecode.request.OrderLineItemRequest;
import avenuecode.request.PlaceOrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eheitmuller on 6/18/17.
 */

public interface OrdersService {
    Order placeOrder(PlaceOrderRequest request);
    List<OrderLineItem> getOrderLineItemsFromRequest(List<OrderLineItemRequest> requests,
                                                     Order order);
}
