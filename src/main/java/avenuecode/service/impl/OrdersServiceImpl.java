package avenuecode.service.impl;

import avenuecode.model.Order;
import avenuecode.model.OrderLineItem;
import avenuecode.model.Product;
import avenuecode.repo.OrderRepository;
import avenuecode.repo.ProductRepository;
import avenuecode.request.OrderLineItemRequest;
import avenuecode.request.PlaceOrderRequest;
import avenuecode.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eheitmuller on 6/18/17.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order placeOrder(PlaceOrderRequest request) {
        Order order = new Order();

        if(null == request.getDestination()){
            throw new IllegalArgumentException("order destination is required");
        }

        order.setDestination(request.getDestination());

        if(null == request.getLineItems() || request.getLineItems().size() < 1){
            throw new IllegalArgumentException("order requires at least 1 line item");
        }

        for (OrderLineItemRequest lineItem: request.getLineItems()) {

            if(lineItem.getAmount() < 1){
                throw new IllegalArgumentException("line items must contain an amount greater than 0");
            }

            Product p = productRepository.findOne(lineItem.getProductId());

            if(null == p ){
                throw new IllegalArgumentException(lineItem.getProductId() + " is not a valid product id");
            }

            order.getOrderLineItems().add(new OrderLineItem(p, lineItem.getAmount(), order));
        }

        return orderRepository.save(order);
    }
}
