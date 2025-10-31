package serviceImpl;

import domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import service.OrderService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor          // genera ctor con 'repository'
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;   // final = requerido en el ctor

    @Override
    public Order create(Order order) {
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
        current.setCustomerName(updated.getCustomerName());
        current.setItems(updated.getItems());
        current.setTotalAmount(updated.getTotalAmount());
        current.setStatus(updated.getStatus());
        return repository.save(current);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}



