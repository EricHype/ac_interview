package service;

import avenuecode.request.PlaceOrderRequest;
import avenuecode.service.OrdersService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by eheitmuller on 6/18/17.
 */
public class OrderServiceTests {

    @Autowired
    OrdersService ordersService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionPlacingOrderWithNoDestination(){
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setDestination(null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("order destination is required");
        ordersService.placeOrder(request);
    }

    @Test
    public void shouldThrowExceptionPlacingOrderWithNoLineItems(){
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setDestination("Test House - 234 Anywhere st");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("order requires at least 1 line item");
        ordersService.placeOrder(request);
    }

    @Test
    public void shouldThrowExceptionPlacingOrderWithLineItemsWithBadAmount() {
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setDestination("Test House - 234 Anywhere st");
        PlaceOrderRequest.OrderLineItemRequest lineItemRequest =
                new PlaceOrderRequest.OrderLineItemRequest();
        lineItemRequest.setAmount(-1);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("order requires at least 1 line item");
        ordersService.placeOrder(request);

    }
}
