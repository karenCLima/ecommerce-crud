package br.ada.customer.crud.view.customer.modelview;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.list.IListModelView;
import br.ada.customer.crud.view.component.text.impl.SimpleTextView;

public class CustomerListModelView implements IListModelView<Customer> {

    @Override
    public View[] convert(Customer customer) {
        SimpleTextView[] line = new SimpleTextView[3];
        line[0] = new SimpleTextView(customer.getId().toString(), 10);
        line[1] = new SimpleTextView(customer.getName(), 20);
        line[2] = new SimpleTextView(customer.getDocument(), 15);
        return line;
    }

}
