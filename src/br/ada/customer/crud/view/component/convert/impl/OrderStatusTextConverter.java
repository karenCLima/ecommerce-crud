package br.ada.customer.crud.view.component.convert.impl;

import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.view.component.convert.IViewConverter;

public class OrderStatusTextConverter implements IViewConverter<OrderStatus, String> {

	@Override
	public String convert(OrderStatus value) {
		return value.toString();
	}

	@Override
	public OrderStatus unConvert(String value) {
		return OrderStatus.valueOf(value);
	}

}
