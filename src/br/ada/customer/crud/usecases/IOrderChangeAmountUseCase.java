package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;

public interface IOrderChangeAmountUseCase {
	
	/*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Trocar a quantidade que foi vendida desse produto
     * 3 - Lembrar de atualizar o banco através do repository
     */
    OrderItem changeAmount(Order order, Product product, Integer amount);

}
