package com.example.microservices.controllers;


import com.example.microservices.dtos.ProductOrderDTO;
import com.example.microservices.entities.Orders;
import com.example.microservices.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class testController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    OrderService orderService;


        //Service Controllers

    @PostMapping(value = "/add")
    public ResponseEntity<Orders> addOrder(
            @RequestBody Orders orders
    ){
     return new ResponseEntity<Orders>(orderService.addOrder(orders), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public List<Orders>getOrders(){
      return orderService.allOrders();
    }

    @GetMapping("/order/{id}")
    public Orders getData(
            @PathVariable(name = "id")  int id
    ){
     return orderService.findOrder(id);
    }

    @GetMapping("/order")
    public Orders getOrderData(){
        String url = "http://localhost:8080/order/102";
        return restTemplate.getForObject(url, Orders.class);

    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam Integer orderNumber){
        orderService.deleteOrder(orderNumber);
    }

    public ResponseEntity<ProductOrderDTO> getOrderWithProductId(@PathVariable int id){
        return new ResponseEntity<>(orderService.getOrderWithProduct(id),HttpStatus.FOUND);
    }

/*
    @GetMapping("")
    public  getOrderbyProductId(){

    }*/


   /* @GetMapping("/data")
    public Orders getData(){
         return getRequestMapping.getData();
    }*/

}
