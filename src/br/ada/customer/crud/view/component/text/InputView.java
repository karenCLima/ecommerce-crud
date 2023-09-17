package br.ada.customer.crud.view.component.text;

import br.ada.customer.crud.view.component.View;

public interface InputView<T> extends View {

    T value();

    String title();

}
