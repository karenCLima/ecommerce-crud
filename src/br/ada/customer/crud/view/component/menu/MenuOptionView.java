package br.ada.customer.crud.view.component.menu;

import br.ada.customer.crud.view.component.View;

public interface MenuOptionView extends View, Comparable<MenuOptionView> {

    Integer order();

    void selected();

    Boolean codeIsMine(String code);

    @Override
    default int compareTo(MenuOptionView other) {
        return order().compareTo(other.order());
    }

}
