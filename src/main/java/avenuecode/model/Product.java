package avenuecode.model;

import javax.persistence.*;

/**
 * Created by ericheitmuller on 6/13/17.
 */
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "name", nullable = false, length = 100)
    String name;

    @Column(name= "price", nullable = false)
    Double price;

    public Product(){

    }

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
