package avenuecode.ws;

import avenuecode.model.Product;
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
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    public void shouldGetProductWhenIdIsValid(){
        Product p = productController.getProduct(1);
        Assert.assertTrue(p.getId() == 1);
    }

    @Test
    public void shouldGetAllProducts(){
        List<Product> productList = productController.getAllProducts();
        Assert.assertTrue(productList.size() > 1);
    }
}
