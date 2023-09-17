package br.ada.customer.crud;

import br.ada.customer.crud.view.menu.MainMenu;

public class Main {

    public static void main(String[] args) {
        MainMenu mainView = new MainMenu();
        mainView.render();
    }

}