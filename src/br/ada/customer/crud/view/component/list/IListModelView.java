package br.ada.customer.crud.view.component.list;

import br.ada.customer.crud.view.component.View;

public interface IListModelView<T> {

    View[] convert(T object);

}
