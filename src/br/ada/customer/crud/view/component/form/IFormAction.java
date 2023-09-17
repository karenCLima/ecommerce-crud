package br.ada.customer.crud.view.component.form;

@FunctionalInterface
public interface IFormAction<T> {

    void formExecute(T object);

}
