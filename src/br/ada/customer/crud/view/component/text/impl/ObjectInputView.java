package br.ada.customer.crud.view.component.text.impl;

import br.ada.customer.crud.view.component.convert.IViewConverter;
import br.ada.customer.crud.view.component.text.InputView;

import java.util.Scanner;

public class ObjectInputView<T> implements InputView<T> {

    private String title;
    private String value;
    private Scanner scanner = new Scanner(System.in);
    private IViewConverter<T, String> converter;

    public ObjectInputView(String title, IViewConverter<T, String> converter) {
        this.title = title;
        this.converter = converter;
    }


    @Override
    public void render() {
        System.out.print(title);
        this.value = scanner.nextLine();
    }

    @Override
    public T value() {
        return converter.unConvert(value);
    }

    @Override
    public String title() {
        return title;
    }

}
