package br.ada.customer.crud.view.component.menu.impl;

import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class InvalidOptionView implements MenuOptionView {

    private View retry;

    public InvalidOptionView(View retry) {
        this.retry = retry;
    }

    @Override
    public void render() {
        System.out.println("Opção invalida.");
    }

    @Override
    public Integer order() {
        return 1000;
    }

    @Override
    public void selected() {
        retry.render();
    }

    @Override
    public Boolean codeIsMine(String code) {
        return false;
    }

}
