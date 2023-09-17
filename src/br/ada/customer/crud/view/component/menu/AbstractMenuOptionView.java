package br.ada.customer.crud.view.component.menu;

public abstract class AbstractMenuOptionView implements MenuOptionView {

    private String code;
    private Integer order;

    public AbstractMenuOptionView(String code, Integer order) {
        this.code = code;
        this.order = order;
    }

    @Override
    public Integer order() {
        return order;
    }


    @Override
    public Boolean codeIsMine(String code) {
        return this.code.equals(code);
    }


}
