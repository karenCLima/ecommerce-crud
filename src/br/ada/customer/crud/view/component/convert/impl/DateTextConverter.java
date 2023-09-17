package br.ada.customer.crud.view.component.convert.impl;

import br.ada.customer.crud.view.component.convert.IViewConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTextConverter implements IViewConverter<LocalDate, String> {

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String convert(LocalDate value) {
        return value.format(dateFormatter);
    }

    @Override
    public LocalDate unConvert(String value) {
        return LocalDate.parse(value, dateFormatter);
    }

}
