package avenuecode.service;

import avenuecode.model.Order;
import avenuecode.request.PlaceOrderRequest;
import org.springframework.stereotype.Service;

/**
 * Created by eheitmuller on 6/18/17.
 */

public interface OrdersService {
    Order placeOrder(PlaceOrderRequest request);
}
