package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IOrderNotifierUseCase;
import br.ada.customer.crud.usecases.IOrderPayUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.usecases.repository.RepositoryException;

public class OrderPayUseCaseImpl implements IOrderPayUseCase {
	
	private OrderRepository repository;
	private IOrderNotifierUseCase notifier;
	
	

	public OrderPayUseCaseImpl(OrderRepository repository, IOrderNotifierUseCase notify) {
		this.repository = repository;
		this.notifier = notify;
	}



	@Override
	public void pay(Order order) {
		if(order.getStatus() == OrderStatus.PENDING_PAYMENT) {
			order.setStatus(OrderStatus.PAID);
			repository.update(order);
			notifier.notify(order);
		}else {
			throw new RuntimeException("O pagamento tem que estar com o status: PENDING_PAYMENT!");
		}
		
	}

}
