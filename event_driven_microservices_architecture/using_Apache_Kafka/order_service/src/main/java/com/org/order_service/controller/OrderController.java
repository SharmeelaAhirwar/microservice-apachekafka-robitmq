package com.org.order_service.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.base_domain.dto.Order;
import com.org.base_domain.dto.OrderEvent;
import com.org.order_service.kafka.OrderProducer;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	  private OrderProducer orderProducer;

	    public OrderController(OrderProducer orderProducer) {
	        this.orderProducer = orderProducer;
	    }

	    @PostMapping("/orders")
	    public String placeOrder(@RequestBody Order order){

	        order.setOrderId(UUID.randomUUID().toString());

	        OrderEvent orderEvent = new OrderEvent();
	        orderEvent.setStatus("PENDING");
	        orderEvent.setMesssage("order status is in pending state");
//	        orderEvent.setMessage("order status is in pending state");
	        orderEvent.setOrder(order);

	        orderProducer.sendMessage(orderEvent);

	        return "Order placed successfully ...";
	    }

}
