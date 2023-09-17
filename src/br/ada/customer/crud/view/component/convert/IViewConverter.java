package br.ada.customer.crud.view.component.convert;

public interface IViewConverter<T, R> {

    R convert(T value);

    T unConvert(R value);

}
