package avenuecode.ws;

import avenuecode.model.Order;
import avenuecode.repo.OrderRepository;
import avenuecode.request.PlaceOrderRequest;
import avenuecode.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
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

    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Order createOrder(@RequestBody PlaceOrderRequest orderRequest){
        Order o = ordersService.placeOrder(orderRequest);
        return o;
    }

    @RequestMapping(value="/order/{id}", method = RequestMethod.GET)
    public @ResponseBody Order getOrder(@PathParam("id") Integer id){
        Order o = orderRepository.findOne(id);
        return o;
    }

    @RequestMapping(value="/order/{id}", method = RequestMethod.PUT)
    public @ResponseBody Order updateOrder(@RequestBody Order order){
        Order o = orderRepository.findOne(order.getId());

        if(null == o){
            throw new IllegalArgumentException("order id " + order.getId() + " not found");
        }

        o.setDestination(order.getDestination());
        o.setOrderLineItems(order.getOrderLineItems());

        return orderRepository.save(o);
    }


    @RequestMapping(value="/orders", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
