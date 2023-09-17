package br.ada.customer.crud.view.component.table;

import br.ada.customer.crud.view.component.View;

import java.util.List;

public class TableView<T> implements View {

    private List<T> registers;
    private ITableModelView<T> modelView;

    public TableView(List<T> registers, ITableModelView<T> modelView) {
        this.registers = registers;
        this.modelView = modelView;
    }

    @Override
    public void render() {
        System.out.print("| ");
        for (View header : modelView.headers()) {
            header.render();
            System.out.print(" | ");
        }
        System.out.println();
        for (T register : registers) {
            System.out.print("| ");
            for (View line : modelView.convert(register)) {
                line.render();
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
