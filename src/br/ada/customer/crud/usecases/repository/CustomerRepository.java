package br.ada.customer.crud.usecases.repository;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByDocument(String document);

    List<Customer> findByName(String name);

}
