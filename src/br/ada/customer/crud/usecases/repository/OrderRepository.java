package br.ada.customer.crud.usecases.repository;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);

}
