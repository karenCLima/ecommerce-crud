package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Product;

import java.util.List;

public interface IProductUseCase {

    void create(Product product);

    List<Product> listAll();

    List<Product> findByDescription(String description);

    Product findByBarcode(String barcode);

    void update(Product product);

    Product delete(Long id);

}
