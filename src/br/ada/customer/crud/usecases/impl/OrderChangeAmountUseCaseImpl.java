package br.ada.customer.crud.usecases.impl;

import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderChangeAmountUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.usecases.repository.RepositoryException;

public class OrderChangeAmountUseCaseImpl implements IOrderChangeAmountUseCase {
	
	private OrderRepository repository;
	
	

	public OrderChangeAmountUseCaseImpl(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public OrderItem changeAmount(Order order, Product product, Integer amount) {
		OrderItem orderItem = null;
		if(order.getStatus() == OrderStatus.OPEN) {
			List<OrderItem> orderItems = order.getItems();
			for (OrderItem orderItemFound : orderItems) {
				if(orderItemFound.getProduct().getId() == product.getId()) {
					orderItemFound.setAmount(amount);
					repository.update(order);
					orderItem = orderItemFound;
				}
			}
		}else {
			throw new RuntimeException("O pedido deveria estar com o status: OPEN!");
		}
		return orderItem;
	}

}
