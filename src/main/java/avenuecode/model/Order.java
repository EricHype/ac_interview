package avenuecode.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericheitmuller on 6/13/17.
 */
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "destination", nullable = false, length = 100)
    String destination;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderLineItem> orderLineItems;

    public Order() {
        orderLineItems = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    @JsonGetter("total")
    public Double getTotal(){
        return orderLineItems.stream()
                .map(li-> li.getAmount() * li.product.price)
                .reduce(0.0, (x, y)-> x+y);
    }
}
