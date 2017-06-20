package avenuecode.service;

import avenuecode.model.Order;
import avenuecode.request.PlaceOrderRequest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by eheitmuller on 6/18/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
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

    @Test
    public void shouldThrowExceptionPlacingOrderWithBadProductId() {
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setDestination("Test House - 234 Anywhere st");
        PlaceOrderRequest.OrderLineItemRequest lineItemRequest =
                new PlaceOrderRequest.OrderLineItemRequest();
        lineItemRequest.setAmount(1);
        lineItemRequest.setProductId(999);
        request.getLineItems().add(lineItemRequest);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("999 is not a valid product id");
        ordersService.placeOrder(request);
    }

    @Test
    public void shouldPlaceAnOrderWhenRequestIsValid(){
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setDestination("Test House - 234 Anywhere st");
        PlaceOrderRequest.OrderLineItemRequest lineItemRequest =
                new PlaceOrderRequest.OrderLineItemRequest();
        lineItemRequest.setAmount(1);
        lineItemRequest.setProductId(2);
        request.getLineItems().add(lineItemRequest);
        Order o = ordersService.placeOrder(request);
        Assert.assertNotNull(o);
    }
}
