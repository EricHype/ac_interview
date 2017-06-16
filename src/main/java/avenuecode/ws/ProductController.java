package avenuecode.ws;

import avenuecode.model.Product;
import avenuecode.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ericheitmuller on 6/13/17.
 *
 * list product catalog
 read a single product by its id
 */
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("product/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        Product p = productRepository.findOne(id);
        return p;
    }

    @RequestMapping("products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
