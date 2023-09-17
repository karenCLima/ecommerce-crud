package br.ada.customer.crud.view.order.modelview;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.convert.impl.CustomerTextConverter;
import br.ada.customer.crud.view.component.form.IFormModelView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;

public class OrderFormModelView implements IFormModelView<Order>{
	
	private ICustomerUseCase customerUseCase = CustomerFactory.createUseCase();
	
	private ObjectInputView<Customer> txtCustomer = new ObjectInputView<>("Informe o nome do cliente:", new CustomerTextConverter(customerUseCase));
	private TextInputView txtShippingAdress = new TextInputView("Informe o endereço: ");
    

	@Override
	public View[] views() {
		return new View[]{
                txtCustomer,
                txtShippingAdress
        };
	}

	@Override
	public void applyUpdate(Order order) {
		order.setCustomer(txtCustomer.value());
		order.setShippingAddress(txtShippingAdress.value());
    }
		
	

}
