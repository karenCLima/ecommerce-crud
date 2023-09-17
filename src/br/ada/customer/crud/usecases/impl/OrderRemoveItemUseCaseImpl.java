package br.ada.customer.crud.usecases.impl;

import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderRemoveItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.usecases.repository.RepositoryException;

public class OrderRemoveItemUseCaseImpl implements IOrderRemoveItemUseCase {
	
	private OrderRepository repository;
	
	

	public OrderRemoveItemUseCaseImpl(OrderRepository repository) {
		this.repository = repository;
	}



	@Override
	public void removeItem(Order order, Product product) {
		if(order.getStatus() == OrderStatus.OPEN) {
			List<OrderItem> orderItems = order.getItems();
			for (OrderItem orderItem : orderItems) {
				if(orderItem.getProduct().getDescription() == product.getDescription()) {
					orderItems.remove(orderItem);
				}else {
					throw new RuntimeException("O Pedido não foi encontrado!");
				}
			}
			order.setItems(orderItems);
			repository.update(order);
		}else {
			throw new RuntimeException("O pedido precisa ter o status: OPEN.");
		}
		
	}
	

}
