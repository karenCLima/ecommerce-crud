package br.ada.customer.crud.view.component.menu.impl;

import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class ExitOptionView implements MenuOptionView {

    public static final String MENU_CODE = "0";
    public static final Integer MENU_ORDER = 1000;

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Sair");
    }

    @Override
    public Integer order() {
        return MENU_ORDER;
    }

    @Override
    public void selected() {
        System.exit(0);
    }

    @Override
    public Boolean codeIsMine(String code) {
        return MENU_CODE.equals(code);
    }

}
