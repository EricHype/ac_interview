package avenuecode.repo;

import avenuecode.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



/**
 * Created by ericheitmuller on 6/13/17.
 */
@org.springframework.stereotype.Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    void delete(Product deleted);
    List<Product> findAll();
    Product findOne(Integer id);
    Product save(Product persisted);
}
