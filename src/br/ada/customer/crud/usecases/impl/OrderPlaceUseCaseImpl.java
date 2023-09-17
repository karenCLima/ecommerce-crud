package br.ada.customer.crud.usecases.impl;

import java.math.BigDecimal;
import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IOrderNotifierUseCase;
import br.ada.customer.crud.usecases.IOrderPlaceUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderPlaceUseCaseImpl implements IOrderPlaceUseCase {
	
	private OrderRepository repository;
	private IOrderNotifierUseCase notifier;
	
	

	public OrderPlaceUseCaseImpl(OrderRepository repository, IOrderNotifierUseCase notifier) {
		this.repository = repository;
		this.notifier = notifier;
	}



	@Override
	public void placeOrder(Order order) {
		if(order.getStatus() == OrderStatus.OPEN) {
			List<OrderItem> orderItems = order.getItems();
			if (orderItems.size()>0 && orderItems != null) {
				BigDecimal totalValue = orderItems.stream().map(OrderItem::getSaleValue).reduce(BigDecimal.ZERO, (valor1, valor2) -> valor1.add(valor2));
				if (totalValue.compareTo(BigDecimal.ZERO) >0) {
					notifier.notify(order);
					order.setStatus(OrderStatus.PENDING_PAYMENT);
					repository.save(order);
				}else {
					throw new RuntimeException("O valor da compra precisa ser maior que zero!");
				}
			}else {
				throw new RuntimeException("Precisa ter pelo menos um item para confirmar a compra!");
			}
		}else {
			throw new RuntimeException("O pedido precisa ter o status: OPEN.");
		}
		
	}

}
