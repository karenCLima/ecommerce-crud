package br.ada.customer.crud.view.order.modelview;

import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.convert.impl.CustomerTextConverter;
import br.ada.customer.crud.view.component.convert.impl.DateTimeTextConverter;
import br.ada.customer.crud.view.component.convert.impl.OrderStatusTextConverter;
import br.ada.customer.crud.view.component.table.ITableModelView;
import br.ada.customer.crud.view.component.text.impl.FormattedTextView;
import br.ada.customer.crud.view.component.text.impl.SimpleTextView;

public class OrderTableModelView implements ITableModelView<Order> {
	
	private ICustomerUseCase customerUseCase = CustomerFactory.createUseCase();

	@Override
	public View[] headers() {
		SimpleTextView[] headers = new SimpleTextView[5];
        headers[0] = new SimpleTextView("id", 10);
        headers[1] = new SimpleTextView("Customer", 20);
        headers[2] = new SimpleTextView("Ordered at", 20);
        headers[3] = new SimpleTextView("Order Status", 10);
        headers[4] = new SimpleTextView("Address", 40);
        return headers;
	}

	@Override
	public View[] convert(Order order) {
		SimpleTextView[] line = new SimpleTextView[5];
        line[0] = new SimpleTextView(order.getId().toString(), 10);
        line[1] = new FormattedTextView<>(order.getCustomer(), 20, new CustomerTextConverter(customerUseCase));
        line[2] = new FormattedTextView<>(order.getOrderedAt(), 20, new DateTimeTextConverter());
        line[3] = new FormattedTextView<>(order.getStatus(), 10, new OrderStatusTextConverter());
        line[4] = new SimpleTextView(order.getShippingAddress().toString(), 40);
        return line;
	}

}
