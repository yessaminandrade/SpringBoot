package service;

import com.company.orders.domain.Order;

import java.util.List;
import java.util.UUID;

/** Servicio para operaciones CRUD de Order. */
public interface OrderService {
    Order create(Order order);
    Order findById(UUID id);
    List<Order> findAll();
    Order update(UUID id, Order updated);
    void delete(UUID id);
}









