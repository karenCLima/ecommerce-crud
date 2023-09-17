package br.ada.customer.crud.view.component.text.impl;

import br.ada.customer.crud.view.component.convert.IViewConverter;

public class FormattedTextView<T> extends SimpleTextView {

    public FormattedTextView(T value, Integer size, IViewConverter<T, String> converter) {
        super(
                converter.convert(value),
                size
        );
    }

}
