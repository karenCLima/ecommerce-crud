package br.ada.customer.crud.view.component.convert.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.ada.customer.crud.view.component.convert.IViewConverter;

public class DateTimeTextConverter implements IViewConverter<LocalDateTime, String>{
	
	 private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public String convert(LocalDateTime value) {
		return value.format(dateFormatter);
	}

	@Override
	public LocalDateTime unConvert(String value) {
		return LocalDateTime.parse(value, dateFormatter);
	}

}
