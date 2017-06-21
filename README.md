# ac_interview

A simple REST API that offers a bit of CRUD using spring boot with an H2 backend. A few sample records are inserted as part of start up, so please feel free to poke around.

# How to run this code

To build:
>gradle build

To run tests:
>gradle test

To run:
>gradle bootRun

# Endpoints

### Products
* GET /products - lists all products
* GET /product/{id} - gets a specific product by Id

### Orders
* GET /orders - lists all orders
* GET /order/{id} - gets an order by id
* POST /order - creates a new order
* PUT /order/{id} - updates an order with new destination/items

# Sample payloads

* Create Order
>{"destination": "123 My street","lineItems" : [{ "productId" : 1, "amount" : 1 }]}

* Update Order
>{"destination": "456 My street","lineItems" : [{ "productId" : 3, "amount" : 3 }]}
