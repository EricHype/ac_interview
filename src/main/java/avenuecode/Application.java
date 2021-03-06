package avenuecode;

import avenuecode.model.Order;
import avenuecode.model.OrderLineItem;
import avenuecode.model.Product;
import avenuecode.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import avenuecode.repo.OrderRepository;
import avenuecode.repo.ProductRepository;

import java.util.List;

/**
 * Created by ericheitmuller on 6/13/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrdersService ordersService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("Product1", 1.00);
        Product p2 = new Product("Product2", 2.00);
        Product p3 = new Product("Product3", 3.00);

        productRepository.save(p1);
        productRepository.save(p2);

        List<Product> products = productRepository.findAll();

        for(Product p : products){
            logger.info(p.getName() + " " + p.getId());
        }

        Order o = new Order();
        o.setDestination("My house - 123 Anywhere st");
        o.getOrderLineItems().add(new OrderLineItem(p1, 100, o));
        o.getOrderLineItems().add(new OrderLineItem(p2, 200, o));

        orderRepository.save(o);

    }
}

