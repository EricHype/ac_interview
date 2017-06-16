package avenuecode.model;

import javax.persistence.*;
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
}
