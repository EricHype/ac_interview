package avenuecode.ws;

import avenuecode.model.Order;
import avenuecode.request.OrderLineItemRequest;
import avenuecode.request.PlaceOrderRequest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eheitmuller on 6/18/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrderControllerTests {
    @Autowired
    OrderController orderController;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void shouldThrowExceptionWhenUpdatingOrderOfBadId(){
        Order o = orderController.getOrder(1);
        o.setId(999);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("order id " + o.getId() + " not found");
        orderController.updateOrder(o);
    }

    @Test
    public void shouldUpdateWhenUpdateIsValid(){
        Order o = orderController.getOrder(1);
        o.setDestination("new destination");
        o.setOrderLineItems(new ArrayList<>());

        Order o2 = orderController.updateOrder(o);

        Assert.assertEquals(o2.getDestination(), "new destination");
        Assert.assertTrue(o2.getOrderLineItems().size() < 1);
    }


}
