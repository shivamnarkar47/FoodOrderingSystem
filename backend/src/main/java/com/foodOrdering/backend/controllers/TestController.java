package com.foodOrdering.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrdering.backend.models.Order;
import com.foodOrdering.backend.models.Transaction;
import com.foodOrdering.backend.payload.response.MessageResponse;
import com.foodOrdering.backend.repository.OrderRepository;
import com.foodOrdering.backend.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1")
public class TestController {
  @Autowired
  OrderRepository orderRepository;

  @Autowired
  TransactionRepository transactionRepository;

  @GetMapping("/orders")
  public ResponseEntity<?> getOrders() {
    System.out.println("Running");
    List<Order> getOrders = orderRepository.findAll();

    return ResponseEntity.ok(getOrders);
  }

  @GetMapping(path = "/order/{userName}")
  @ResponseBody
  public ResponseEntity<?> getOrderById(@PathVariable("userName") String userName) {
    try {
      List<Order> orders = orderRepository.findAll();
      List<Order> order = orderRepository.findByUserName(userName);

      for (Order order2 : orders) {
        if (order2.getUserName() == userName) {
          order.add(order2);
        }
      }

      System.out.println(order);
      return ResponseEntity.ok(order);

    } catch (Error e) {
      System.out.println(e);
      return new ResponseEntity<>("Error is " + e, HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/order/delete/{id}")
  @ResponseBody
  public ResponseEntity<?> deleteOrder(@PathVariable("id") String id) {
    try {
      orderRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Deleted order successfully ! : "));

    } catch (Exception e) {
      return new ResponseEntity<>("Error is " + e, HttpStatus.BAD_REQUEST);
    }
    // return null;

  }

  @PostMapping("/addorders")
  public ResponseEntity<?> setOrders(@RequestBody Order order) {
    Order order2 = new Order(order.getOrderId(), order.getUserName(), order.getOrderDetails(), order.getImgURL(),
        order.getPrice(),
        order.getQuantity(), order.getLocation(), order.getRestaurant(), order.getCompleted(), order.getAvailable());
    orderRepository.save(order2);
    return ResponseEntity.ok(new MessageResponse("Order sent"));
  }

  @PostMapping("/transactions")
  public ResponseEntity<?> setTransactions(@RequestBody Transaction transaction) {
    Transaction t1 = new Transaction(transaction.getTransactionName(), transaction.getOrderDetails(),
        transaction.getPayment_mode(), transaction.getUsername(),
        transaction.getDate());
    transactionRepository.save(t1);

    return ResponseEntity.ok(new MessageResponse("Transaction succesfful"));
  }

  @GetMapping("/transactions")
  public ResponseEntity<?> getTransactions() {
    List<Transaction> getTransactions = transactionRepository.findAll();

    return ResponseEntity.ok(getTransactions);
  }

  @PutMapping("/process/{id}")
  public ResponseEntity<?> processOrder(@PathVariable("id") String id, @RequestBody Order order) {
    try {
      order.setId(id);
      orderRepository.save(order);

      return ResponseEntity.ok(new MessageResponse("Updated Order of " + id + " succesfully"));
    } catch (Exception e) {
      // TODO: handle exception
      return ResponseEntity.ok(new MessageResponse("Cannot Update Order of " + id + " succesfully"));

    }
  }

}
