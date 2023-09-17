package br.ada.customer.crud.integration.email;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.IOrderNotifierUseCase;

public class OrderShippingEmailNotifier implements IOrderNotifierUseCase {
	
	private SendEmail sendEmail;
	
	

	public OrderShippingEmailNotifier(SendEmail sendEmail) {
		super();
		this.sendEmail = sendEmail;
	}

	@Override
	public void notify(Order order) {
		sendEmail.send("comunicado@ecommerce.com.br", order.getCustomer().getEmail(), "Seu pedido está a caminho. Obrigada por comprar conosco!.");
		
	}

}
