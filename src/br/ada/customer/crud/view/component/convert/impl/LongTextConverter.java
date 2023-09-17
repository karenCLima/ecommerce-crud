package br.ada.customer.crud.view.component.convert.impl;

import br.ada.customer.crud.view.component.convert.IViewConverter;

public class LongTextConverter implements IViewConverter<Long, String> {


    @Override
    public String convert(Long value) {
        return value.toString();
    }

    @Override
    public Long unConvert(String value) {
        return Long.valueOf(value);
    }

}
