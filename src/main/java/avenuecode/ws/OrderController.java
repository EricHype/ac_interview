package avenuecode.ws;

import avenuecode.model.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

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

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    Order createOrder(@RequestBody Order order){

    }

    @RequestMapping(value="/order/{id}", method = RequestMethod.GET)
    Order getOrder(@PathParam("id") Integer id){

    }

}
