

package com.example.demo.controller;

import com.example.demo.model.Categories;
import com.example.demo.model.OrderItem;
import com.example.demo.service.ICategoriesService;
import com.example.demo.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping("/orderItm")
    public ResponseEntity<Collection<OrderItem>> getOrderItm() {
        Collection<OrderItem> orderItm= (Collection<OrderItem>) orderItemService.findAll();
        return new ResponseEntity<Collection<OrderItem>>(orderItm, HttpStatus.OK);
    }

    @GetMapping("/orderItm/{id}")
    public ResponseEntity<Optional<OrderItem>>getorderItem(@PathVariable Long id) {
        Optional<OrderItem> orderItem= orderItemService.findOne(id);
        if(orderItem==null){
           return new  ResponseEntity<Optional<OrderItem>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<OrderItem>>(orderItem,HttpStatus.OK);
    }

   @PostMapping("/OrderItm")
    public ResponseEntity<OrderItem> createorderItem(@RequestBody OrderItem orderItemCreate) {
       OrderItem saveorderItem= orderItemService.create(orderItemCreate);

        return new ResponseEntity<OrderItem>(saveorderItem, HttpStatus.CREATED);
    }

    @PutMapping("/orderItm")
    public ResponseEntity<OrderItem> updateorderItem(@RequestBody OrderItem createorderItem) {
        OrderItem saveorderItem = orderItemService.update(createorderItem);

            return new ResponseEntity<OrderItem>(saveorderItem, HttpStatus.OK);
    }
    @DeleteMapping("/OrderItm/{id}")
    public ResponseEntity<OrderItem> deleteorderItem(@PathVariable Long id) {
        orderItemService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


