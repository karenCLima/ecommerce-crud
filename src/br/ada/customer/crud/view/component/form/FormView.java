package br.ada.customer.crud.view.component.form;

import br.ada.customer.crud.view.component.View;

public class FormView<T> implements View {

    private T object;
    private IFormModelView<T> modelView;
    private IFormAction<T> action;

    public FormView(T object, IFormModelView<T> modelView, IFormAction<T> action) {
        this.object = object;
        this.modelView = modelView;
        this.action = action;
    }

    @Override
    public void render() {
        for (View view : modelView.views()) {
            view.render();
        }
        update();
    }

    protected void update() {
        modelView.applyUpdate(object);
        action.formExecute(object);
    }

}
