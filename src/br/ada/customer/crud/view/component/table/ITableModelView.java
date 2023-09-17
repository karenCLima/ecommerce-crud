package br.ada.customer.crud.view.component.table;

import br.ada.customer.crud.view.component.View;

public interface ITableModelView<T> {

    View[] headers();

    View[] convert(T object);

}
