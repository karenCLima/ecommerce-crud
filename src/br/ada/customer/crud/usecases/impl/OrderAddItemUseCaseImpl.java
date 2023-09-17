package br.ada.customer.crud.usecases.impl;

import java.math.BigDecimal;
import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderAddItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderAddItemUseCaseImpl implements IOrderAddItemUseCase{
	
	private OrderRepository repository;

	public OrderAddItemUseCaseImpl(OrderRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public OrderItem addItem(Order order, Product product, BigDecimal price, Integer amount) {
		if(order.getStatus() == OrderStatus.OPEN) {
			OrderItem orderItem = new OrderItem();
			List<OrderItem> listItems = order.getItems();
			orderItem.setProduct(product);
			orderItem.setSaleValue(price);
			orderItem.setAmount(amount);
			listItems.add(orderItem);
			order.setItems(listItems);
			repository.update(order);
			return orderItem;
		}else {
			throw new RuntimeException("O pedido precisa estar com o status: OPEN.");
		}
	}

}
