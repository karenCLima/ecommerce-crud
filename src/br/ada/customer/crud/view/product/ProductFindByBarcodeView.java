package br.ada.customer.crud.view.product;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;
import br.ada.customer.crud.view.product.modelview.ProductListModelView;

import java.util.List;

public class ProductFindByBarcodeView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "3";
    public static final Integer MENU_ORDER = 3;
    private IProductUseCase useCase;

    public ProductFindByBarcodeView(IProductUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Consultar por código");
    }

    @Override
    public void selected() {
        TextInputView txtBarcode = new TextInputView("Informe o código: ");
        txtBarcode.render();

        Product product = useCase.findByBarcode(txtBarcode.value());
        ListView<Product> listView = new ListView<>(List.of(product), new ProductListModelView());
        listView.render();

    }

}
