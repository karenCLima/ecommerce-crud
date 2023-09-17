package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.Product;

public interface IOrderRemoveItemUseCase {

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Lembrar de atualizar o banco através do repository
     */
    void removeItem(Order order, Product product);

}
