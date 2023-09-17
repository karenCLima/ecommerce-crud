package br.ada.customer.crud.view.component.menu.impl;

import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class GoBackOptionView implements MenuOptionView {

    public static final String MENU_CODE = "0";
    public static final Integer MENU_ORDER = 1000;
    private View goBackTo;

    public GoBackOptionView(View goBackTo) {
        this.goBackTo = goBackTo;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Voltar");
    }

    @Override
    public Integer order() {
        return MENU_ORDER;
    }

    @Override
    public void selected() {
        goBackTo.render();
    }

    @Override
    public Boolean codeIsMine(String code) {
        return MENU_CODE.equals(code);
    }

}
