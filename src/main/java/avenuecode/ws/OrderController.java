package avenuecode.ws;

import avenuecode.model.Order;
import avenuecode.repo.OrderRepository;
import avenuecode.request.PlaceOrderRequest;
import avenuecode.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by ericheitmuller on 6/13/17.
 *
 * place an order
 modify an existing order
 list placed orders
 read an existing order by its id
 *
 */
@RestController
public class OrderController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Order createOrder(@RequestBody PlaceOrderRequest orderRequest){
        Order o = ordersService.placeOrder(orderRequest);
        return o;
    }

    @RequestMapping(value="/order/{id}", method = RequestMethod.GET)
    public @ResponseBody Order getOrder(@PathVariable("id") int id){
        Order o = orderRepository.findOne(id);
        return o;
    }

    @RequestMapping(value="/order/{id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Order updateOrder(@PathVariable("id") int id,
                                           @RequestBody PlaceOrderRequest orderRequest){
        Order o = orderRepository.findOne(id);

        if(null == o){
            throw new IllegalArgumentException("order id " + id + " not found");
        }

        o.setDestination(orderRequest.getDestination());
        o.setOrderLineItems(ordersService.getOrderLineItemsFromRequest(
                orderRequest.getLineItems(), o));

        return orderRepository.save(o);
    }


    @RequestMapping(value="/orders", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
