package avenuecode.ws;

import avenuecode.model.Order;
import avenuecode.request.OrderLineItemRequest;
import avenuecode.request.PlaceOrderRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by eheitmuller on 6/18/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrderControllerTests {
    @Autowired
    OrderController orderController;

    @Test
    public void shouldGetOrderWhenIdIsValid(){
        Order o = orderController.getOrder(1);
        Assert.assertTrue(o.getId() == 1);
    }

    @Test
    public void shouldGetAllOrders(){
        List<Order> orderList = orderController.getAllOrders();
        Assert.assertTrue(orderList.size() > 0);
    }

    @Test
    public void shouldPlaceOrderWhenRequestIsValid(){
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setDestination("224 Integration street");
        OrderLineItemRequest lineItemRequest =
                new OrderLineItemRequest();
        lineItemRequest.setAmount(1);
        lineItemRequest.setProductId(2);
        request.getLineItems().add(lineItemRequest);

        Order o = orderController.createOrder(request);
        Assert.assertTrue(o.getId() > 1);
    }
}
