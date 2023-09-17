package br.ada.customer.crud.view.customer.modelview;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.view.component.convert.impl.DateTextConverter;
import br.ada.customer.crud.view.component.table.ITableModelView;
import br.ada.customer.crud.view.component.text.impl.FormattedTextView;
import br.ada.customer.crud.view.component.text.impl.SimpleTextView;

public class CustomerTableModelView implements ITableModelView<Customer> {

    @Override
    public SimpleTextView[] headers() {
        SimpleTextView[] headers = new SimpleTextView[6];
        headers[0] = new SimpleTextView("id", 10);
        headers[1] = new SimpleTextView("nome", 20);
        headers[2] = new SimpleTextView("document", 15);
        headers[3] = new SimpleTextView("email", 20);
        headers[4] = new SimpleTextView("telefone", 20);
        headers[5] = new SimpleTextView("data nasc.", 10);
        return headers;
    }

    @Override
    public SimpleTextView[] convert(Customer customer) {
        SimpleTextView[] line = new SimpleTextView[6];
        line[0] = new SimpleTextView(customer.getId().toString(), 10);
        line[1] = new SimpleTextView(customer.getName(), 20);
        line[2] = new SimpleTextView(customer.getDocument(), 15);
        line[3] = new SimpleTextView(customer.getEmail().toString(), 20);
        line[4] = new SimpleTextView(customer.getTelephone().toString(), 20);
        line[5] = new FormattedTextView<>(customer.getBirthDate(), 10, new DateTextConverter());
        return line;
    }

}
