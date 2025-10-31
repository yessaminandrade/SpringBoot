package service;

import domain.Order;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order create(Order order);
    Order findById(UUID id);
    List<Order> findAll();
    Order update(UUID id, Order updated);
    void delete(UUID id);
}


