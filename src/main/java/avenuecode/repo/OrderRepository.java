package avenuecode.repo;

import avenuecode.model.Order;
import org.springframework.data.repository.CrudRepository;


import java.util.List;


/**
 * Created by ericheitmuller on 6/13/17.
 */
@org.springframework.stereotype.Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    void delete(Order deleted);
    List<Order> findAll();
    Order findOne(Integer id);
    Order save(Order persisted);
}
