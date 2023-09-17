package br.ada.customer.crud.integration.email;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.IOrderNotifierUseCase;

public class OrderPlaceEmailNotifier implements IOrderNotifierUseCase{
	
	private SendEmail sendEmail;
	
	

	public OrderPlaceEmailNotifier(SendEmail sendEmail) {
		this.sendEmail = sendEmail;
	}



	@Override
	public void notify(Order order) {
		sendEmail.send("comunicado@ecommerce.com.br", order.getCustomer().getEmail(), "Para receber o seu pedido, por favor, efetue o pagamento!");
		
	}

}
