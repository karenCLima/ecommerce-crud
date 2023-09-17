package br.ada.customer.crud.view.component.text.impl;


import br.ada.customer.crud.view.component.text.InputView;

import java.util.Scanner;

public class TextInputView implements InputView<String> {

    private String text;
    private String value;
    private Scanner scanner = new Scanner(System.in);

    public TextInputView(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.print(text);
        this.value = scanner.nextLine();
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String title() {
        return text;
    }

	
		
	

}
