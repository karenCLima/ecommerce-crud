package br.ada.customer.crud.view.component.convert.impl;

import br.ada.customer.crud.view.component.convert.IViewConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTextConverter implements IViewConverter<BigDecimal, String> {

    @Override
    public String convert(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_DOWN).toString();
    }

    @Override
    public BigDecimal unConvert(String value) {
        return new BigDecimal(value);
    }

}
