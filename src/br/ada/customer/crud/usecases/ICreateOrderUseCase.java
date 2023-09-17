package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.model.Order;

public interface ICreateOrderUseCase {


    /*
     * 1 - Inicia um novo pedido para o cliente
     * 2 - Pedido deve iniciar com status igual a OrderStatus.OPEN
     * 3 - Lembrar de atualizar o banco através do repository
     */
    Order create(Customer customer);

}
