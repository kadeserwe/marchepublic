package com.example.demo;
import com.example.demo.dao.CommandesDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.OrderItemDao;
import com.example.demo.dao.ProduitsDao;
import com.example.demo.model.Commandes;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Produits;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class OneToManyUnidirectionalMappingTest {

    @Autowired
    private OrderDao orderRepository;

    @Autowired
    private OrderItemDao orderItemRepository;

//    @Autowired
//    private CommandesDao commandeRepository;
//    @Autowired
//    private ProduitsDao produitRepository;

    @Test
    void testSaveOrder(){

        // create Order object
        Order order = new Order();

        OrderItem orderItem = new OrderItem();
        orderItem.setImageUrl("image_url.png");
        orderItem.setPrice(new BigDecimal(100));
        // add orderitem to order
        order.add(orderItem);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setImageUrl("image_url.png");
        orderItem2.setPrice(new BigDecimal(200));
        // add orderItem2 to order
        order.add(orderItem2);

        order.setOrderTrackingNumber("1000");
        order.setStatus("IN PROGRESS");
        // total amount of the order
        order.setTotalPrice(order.getTotalAmount());

        // Quantity of the order items
        order.setTotalQuantity(2);

        orderRepository.save(order);

    }

    @Test
    void testUpdateOrder(){
        Order order = orderRepository.findById(1L).get();
       // order.setStatus("DELIVERED");
      //  orderRepository.save(order);
        System.out.println("orderItem :: " + order);

    }

    @Test
    @Transactional
    void testGetAllOrders5(){


        List<Order> orders = orderRepository.findAll();
       // Set<OrderItem> ordersItem = new HashSet<>();
       List<OrderItem> ordersItems = orderItemRepository.findAll();

        ordersItems.forEach((ordersItem -> {
           // System.out.println("o.getOrderItems()"+o.getOrderItems());
            System.out.println("----------ordersItem  getId:: " + ordersItem.getId() );
           // if(ordersItem.getId().equals(o.getOrderItems()))
              //  ordersIte.add(ordersItem.getImageUrl());
          //  System.out.println("++++++++++++++++ordersItems :: " + ordersIte);
        }));

//        Set<String> ordersIte =new HashSet<>();
//        orders.forEach((o) -> {
//            // ordersItem =  o.getOrderItems();
//            System.out.println("order id getOrderItems :: " + o.getId());
//             ordersItems.forEach((ordersItem -> {
//                 System.out.println("o.getOrderItems()"+o.getOrderItems());
//                 System.out.println("----------ordersItem  getId:: " + ordersItem.getId() );
//                 if(ordersItem.getId().equals(o.getOrderItems()))
//                     ordersIte.add(ordersItem.getImageUrl());
//                 System.out.println("++++++++++++++++ordersItems :: " + ordersIte);
//            }));
//            System.out.println("ordersIte :: " + ordersIte);
////            o.getOrderItems().forEach((orderItem -> {
////                System.out.println("orderItem :: " + orderItem.getId());
////            }));
//        });
    }

//    @Test
//    void testFindByOrderTrackingNumber(){
//
//        Order order = orderRepository.findByOrderTrackingNumber("1000");
//
//        // add fetch type as EAGER
////        order.getOrderItems().forEach((o) -> {
////            System.out.println(o.getId());
////        });
//    }

//    @Test
//    void testDeleteOrder(){
//
//        orderRepository.deleteById(1L);
//    }

    @Test
    void testSaveOrderd(){

        // create Order object
        Order order = new Order();

        OrderItem orderItem = new OrderItem();
        orderItem.setImageUrl("image_url.png");
        orderItem.setPrice(new BigDecimal(300));
        orderItem.setOrder(order);
        // add orderitem to order
        order.add(orderItem);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setImageUrl("image_url1.png");
        orderItem2.setPrice(new BigDecimal(200));
        orderItem2.setOrder(order);
        // add orderItem2 to order
        order.add(orderItem2);

        order.setOrderTrackingNumber("5000");
        order.setStatus("default");
        // total amount of the order
        order.setTotalPrice(order.getTotalAmount());

        // Quantity of the order items
        order.setTotalQuantity(2200);

        orderRepository.save(order);

    }
//@Test
//void testUpdateOrder(){
//    Order order = orderRepository.findById(2L).get();
//    order.setStatus("DELIVERED");
//    orderRepository.save(order);
//}

    @Test
    void testGetAllOrders(){

        List<Order> orders = orderRepository.findAll();

        orders.forEach((o) -> {

            System.out.println("order id :: " + o.getId());

            o.getOrderItems().forEach((orderItem -> {

                System.out.println("orderItem :: " + orderItem.getId());

                System.out.println("orderItem :: " + orderItem.getOrder());
            }));
        });
    }

//    @Test
//    void testInser(){
////        Produits pd = produitRepository.getOne(new Long(31));
////
////       Commandes cmd = commandeRepository.getOne(new Long(26));
////        System.out.println("ordersItem :: " + cmd);
////       cmd.setProduit(pd);
//        System.out.println("ordersItem :: ++++++++");
//    }


    @Test
    void testGetAllOrdersItem(){

        List<OrderItem> ordersItem = orderItemRepository.findAll();
        System.out.println("ordersItem :: " + ordersItem);

        ordersItem.forEach((o) -> {

            System.out.println("order id :: " + o.getPrice());

//            o.getOrderItems().forEach((orderItem -> {
//
//                System.out.println("orderItem :: " + orderItem.getId());
//
//                System.out.println("orderItem :: " + orderItem.getOrder());
//            }));
        });
    }

}
