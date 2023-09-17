package br.ada.customer.crud.view.product.modelview;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.list.IListModelView;
import br.ada.customer.crud.view.component.text.impl.SimpleTextView;

public class ProductListModelView implements IListModelView<Product> {
    @Override
    public View[] convert(Product product) {
        SimpleTextView[] line = new SimpleTextView[2];
        line[0] = new SimpleTextView(product.getId().toString(), 10);
        line[1] = new SimpleTextView(product.getDescription(), 20);
        return line;
    }
}
