package br.ada.customer.crud.view.component.list;

import br.ada.customer.crud.view.component.View;

import java.util.List;

public class ListView<T> implements View {

    private List<T> registers;
    private IListModelView<T> modelView;

    public ListView(List<T> registers, IListModelView<T> modelView) {
        this.registers = registers;
        this.modelView = modelView;
    }

    @Override
    public void render() {
        for (T register : registers) {
            System.out.print("- ");
            for (View line : modelView.convert(register)) {
                line.render();
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
