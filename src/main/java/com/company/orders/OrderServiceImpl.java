package com.company.orders;

import config.AppProperties;              // ← paquete real: config
import com.company.orders.domain.Order;   // ← igual que en tu OrderService
import repository.OrderRepository;        // ← paquete real: repository
import service.OrderService;              // ← tu interfaz vive en 'service'

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final AppProperties props;

    public OrderServiceImpl(OrderRepository repository, AppProperties props) {
        this.repository = repository;
        this.props = props;
    }

    @Override
    public Order create(Order order) {
        // Validación sprint 2: respetar max-items desde AppProperties
        Integer maxItems = null;
        if (props != null && props.getOrders() != null) {
            maxItems = props.getOrders().getMaxItems();
        }
        if (maxItems != null && order.getItems() != null && order.getItems().size() > maxItems) {
            throw new IllegalArgumentException("Too many items. Max allowed: " + maxItems);
        }
        return repository.save(order);
    }

    @Override
    public Order findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order update(UUID id, Order updated) {
        Order current = findById(id);

        // Copiar campos editables (ajusta si tu entidad tiene otros)
        current.setCustomerName(updated.getCustomerName());
        current.setItems(updated.getItems());
        current.setTotalAmount(updated.getTotalAmount());
        current.setStatus(updated.getStatus());

        // Revalidar max-items
        Integer maxItems = null;
        if (props != null && props.getOrders() != null) {
            maxItems = props.getOrders().getMaxItems();
        }
        if (maxItems != null && current.getItems() != null && current.getItems().size() > maxItems) {
            throw new IllegalArgumentException("Too many items. Max allowed: " + maxItems);
        }

        return repository.save(current);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}














