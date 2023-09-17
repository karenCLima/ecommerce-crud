package br.ada.customer.crud.view.component.text.impl;

import br.ada.customer.crud.view.component.text.TextView;

public class SimpleTextView implements TextView {

    private String value;
    private Integer size;

    public SimpleTextView(String value) {
        this.value = value;
        this.size = value.length();
    }

    public SimpleTextView(String value, Integer size) {
        this.value = value;
        this.size = size;
    }

    @Override
    public String value() {
        return value;
    }

    protected String padRight(String value, Integer size) {
        return String.format("%-" + size + "s", value);
    }

    @Override
    public void render() {
        System.out.print(padRight(value, size));
    }

}
