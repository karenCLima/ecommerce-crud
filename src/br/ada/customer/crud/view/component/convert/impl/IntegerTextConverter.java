package br.ada.customer.crud.view.component.convert.impl;

import br.ada.customer.crud.view.component.convert.IViewConverter;

public class IntegerTextConverter implements IViewConverter<Integer, String>{

	@Override
	public String convert(Integer value) {
		return String.valueOf(value);
	}

	@Override
	public Integer unConvert(String value) {
		return Integer.valueOf(value);
	}

}
