package br.ada.customer.crud.integration.email;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.IOrderNotifierUseCase;

public class OrderPayEmailNotifier implements IOrderNotifierUseCase{
	
	private SendEmail sendEmail;
	
	

	public OrderPayEmailNotifier(SendEmail sendEmail) {
		super();
		this.sendEmail = sendEmail;
	}

	@Override
	public void notify(Order order) {
		sendEmail.send("comunicado@ecommerce.com.br", order.getCustomer().getEmail(), "Seu pagamento foi confirmado!");
		
	}

}
