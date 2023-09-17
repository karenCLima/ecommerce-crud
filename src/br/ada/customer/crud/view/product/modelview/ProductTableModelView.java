package br.ada.customer.crud.view.product.modelview;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.view.component.convert.impl.BigDecimalTextConverter;
import br.ada.customer.crud.view.component.table.ITableModelView;
import br.ada.customer.crud.view.component.text.impl.FormattedTextView;
import br.ada.customer.crud.view.component.text.impl.SimpleTextView;

public class ProductTableModelView implements ITableModelView<Product> {

    @Override
    public SimpleTextView[] headers() {
        SimpleTextView[] headers = new SimpleTextView[4];
        headers[0] = new SimpleTextView("id", 10);
        headers[1] = new SimpleTextView("description", 20);
        headers[2] = new SimpleTextView("barcode", 20);
        headers[3] = new SimpleTextView("value", 8);
        return headers;
    }

    @Override
    public SimpleTextView[] convert(Product product) {
        SimpleTextView[] line = new SimpleTextView[4];
        line[0] = new SimpleTextView(product.getId().toString(), 10);
        line[1] = new SimpleTextView(product.getDescription(), 20);
        line[2] = new SimpleTextView(product.getBarcode(), 20);
        line[3] = new FormattedTextView<>(product.getPrice(), 8, new BigDecimalTextConverter());
        return line;
    }

}
