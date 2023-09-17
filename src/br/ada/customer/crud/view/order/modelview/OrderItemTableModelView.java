package br.ada.customer.crud.view.order.modelview;


import br.ada.customer.crud.factory.ProductFactory;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.usecases.repository.ProductRepository;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.convert.impl.BigDecimalTextConverter;
import br.ada.customer.crud.view.component.convert.impl.IntegerTextConverter;
import br.ada.customer.crud.view.component.convert.impl.ProductTextConverter;
import br.ada.customer.crud.view.component.table.ITableModelView;
import br.ada.customer.crud.view.component.text.impl.FormattedTextView;
import br.ada.customer.crud.view.component.text.impl.SimpleTextView;

public class OrderItemTableModelView implements ITableModelView<OrderItem> {
	
	private ProductRepository productRepository;

	@Override
	public View[] headers() {
		SimpleTextView[] headers = new SimpleTextView[4];
		headers[0] = new SimpleTextView("Id", 10);
        headers[1] = new SimpleTextView("Product", 20);
        headers[2] = new SimpleTextView("Sale Value", 20);
        headers[3] = new SimpleTextView("Amount", 10);
        return headers;
	}

	@Override
	public View[] convert(OrderItem orderItem) {
		SimpleTextView[] line = new SimpleTextView[4];
		line[0] = new SimpleTextView(orderItem.getProduct().getId().toString(), 10);
        line[1] = new FormattedTextView<>(orderItem.getProduct(), 20, new ProductTextConverter(productRepository));
        line[2] = new FormattedTextView<>(orderItem.getSaleValue(), 20, new BigDecimalTextConverter());
        line[3] = new FormattedTextView<>(orderItem.getAmount(), 10, new IntegerTextConverter());
        return line;
	}

}
