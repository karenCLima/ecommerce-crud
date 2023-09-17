package br.ada.customer.crud.view.product.modelview;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.convert.impl.BigDecimalTextConverter;
import br.ada.customer.crud.view.component.form.IFormModelView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;

import java.math.BigDecimal;

public class ProductFormModelView implements IFormModelView<Product> {

    private TextInputView txtDescription = new TextInputView("Informe a descrição: ");
    private TextInputView txtBarcode = new TextInputView(("Informe o código: "));
    private ObjectInputView<BigDecimal> txtPrice = new ObjectInputView<>("Informe o preço:", new BigDecimalTextConverter());

    @Override
    public View[] views() {
        return new View[]{
                txtDescription,
                txtBarcode,
                txtPrice
        };
    }

    @Override
    public void applyUpdate(Product product) {
        product.setDescription(txtDescription.value());
        product.setBarcode(txtBarcode.value());
        product.setPrice(txtPrice.value());
    }
}
