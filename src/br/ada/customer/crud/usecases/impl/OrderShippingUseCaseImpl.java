package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IOrderShippingUseCase;
import br.ada.customer.crud.usecases.IOrderNotifierUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderShippingUseCaseImpl implements IOrderShippingUseCase {

    private OrderRepository repository;
    private IOrderNotifierUseCase notifier;

    public OrderShippingUseCaseImpl(
            OrderRepository repository,
            IOrderNotifierUseCase notifier
    ) {
        this.repository = repository;
        this.notifier = notifier;
    }

    @Override
    public void shipping(Order order) {
        if (order.getStatus() != OrderStatus.PAID) {
            throw new RuntimeException("Pedido ainda não pago.");
        }
        order.setStatus(OrderStatus.FINISH);
        repository.save(order);
        notifier.notify(order);
    }

}
