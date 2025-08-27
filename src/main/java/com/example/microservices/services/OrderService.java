package com.example.microservices.services;

import com.example.microservices.domain.Product;
import com.example.microservices.dtos.ProductOrderDTO;
import com.example.microservices.entities.Orders;
import com.example.microservices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }


    public List<Orders> allOrders(){
     return  orderRepository.findAll();
    }

    public Orders addOrder(Orders orders){
     return orderRepository.save(orders);
    }

    public void deleteOrder(Integer orderNumber){
        orderRepository.deleteById(orderNumber);
    }

    public Orders findOrder(int orderNumber){
       return orderRepository.findById(orderNumber).get();
    }

    public ProductOrderDTO getOrderWithProduct(int orderNumber){
        Orders orders = orderRepository.findById(orderNumber).get();
        Long productId = orders.getProductId();

        Product product = restTemplate.getForObject("localhost:8081/products" + productId, Product.class);
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setOrders(orders);
        productOrderDTO.setProduct(product);

        return  productOrderDTO;
    }

}
