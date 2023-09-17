package br.ada.customer.crud.view.component.convert.impl;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.usecases.repository.ProductRepository;
import br.ada.customer.crud.view.component.convert.IViewConverter;

public class ProductTextConverter implements IViewConverter<Product, String> {
	
	private ProductRepository productRepository;

	public ProductTextConverter(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public String convert(Product value) {
		return value.getDescription();
	}

	@Override
	public Product unConvert(String value) {
		Product product = (Product) productRepository.findByDescription(value);
		return product;
	}


	

}
