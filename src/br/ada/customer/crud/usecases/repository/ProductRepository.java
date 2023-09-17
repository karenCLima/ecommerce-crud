package br.ada.customer.crud.usecases.repository;

import br.ada.customer.crud.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByDescription(String description);

    Product findByBarcode(String barcode);

}
