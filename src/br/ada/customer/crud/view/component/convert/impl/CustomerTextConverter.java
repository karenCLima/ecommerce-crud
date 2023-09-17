package br.ada.customer.crud.view.component.convert.impl;

import java.util.List;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.convert.IViewConverter;

public class CustomerTextConverter implements IViewConverter<Customer, String> {
	
	private ICustomerUseCase customerUseCase;
	
	public CustomerTextConverter(ICustomerUseCase customerUseCase) {
		this.customerUseCase = customerUseCase;
	}

	@Override
	public String convert(Customer value) {
		return value.getName();
	}

	@Override
	public Customer unConvert(String value) {
		List<Customer> customers = customerUseCase.findByName(value);
		Customer customer = customers.get(0); // Pega o primeiro cliente da lista
		return customer;
	}

}
