package avenuecode.service;

import avenuecode.model.Order;
import avenuecode.request.PlaceOrderRequest;

/**
 * Created by eheitmuller on 6/18/17.
 */
public interface OrdersService {
    Order placeOrder(PlaceOrderRequest request);
}
