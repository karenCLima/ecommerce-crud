package br.ada.customer.crud.view.component.menu.impl;

import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;

import java.util.Collections;
import java.util.List;

public class SubMenuView implements View {

    private List<MenuOptionView> options;

    public SubMenuView(List<MenuOptionView> options) {
        this.options = options;
    }

    @Override
    public void render() {
        Collections.sort(options);
        do {
            for (MenuOptionView option : options) {
                option.render();
            }
            String code = captureCode();
            getOption(code).selected();
        } while (1 != 2);
    }

    private MenuOptionView getOption(String code) {
        MenuOptionView found = new InvalidOptionView(this);
        for (MenuOptionView option : options) {
            if (option.codeIsMine(code)) {
                found = option;
            }
        }
        return found;
    }

    private String captureCode() {
        TextInputView txtOption = new TextInputView("Escolha a opção pelo código: ");
        txtOption.render();
        return txtOption.value();
    }

}
