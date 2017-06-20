package avenuecode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ericheitmuller on 6/13/17.
 */
@Entity
@Table(name = "OrderLineItems")
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="product_id")
    Product product;

    @Column(name = "destination", nullable = false, length = 100)
    Integer amount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    public OrderLineItem(){

    }

    public OrderLineItem(Product product, Integer amount, Order order) {
        this.product = product;
        this.amount = amount;
        this.order = order;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getProductId(){
        return product.id;
    }

    public Double getProductPrice(){
        return product.price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }



}
