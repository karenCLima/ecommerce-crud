package br.ada.customer.crud.view.component.form;

import br.ada.customer.crud.view.component.View;

public interface IFormModelView<T> {

    View[] views();

    void applyUpdate(T object);

}
