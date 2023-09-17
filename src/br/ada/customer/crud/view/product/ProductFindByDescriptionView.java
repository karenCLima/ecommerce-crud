package br.ada.customer.crud.view.product;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;
import br.ada.customer.crud.view.product.modelview.ProductListModelView;

import java.util.List;

public class ProductFindByDescriptionView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "4";
    public static final Integer MENU_ORDER = 4;
    private IProductUseCase useCase;

    public ProductFindByDescriptionView(IProductUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Consultar por descrição");
    }

    @Override
    public void selected() {
        TextInputView txtDescription = new TextInputView("Informe a descrição: ");
        txtDescription.render();

        List<Product> products = useCase.findByDescription(txtDescription.value());
        ListView<Product> listView = new ListView<>(products, new ProductListModelView());
        listView.render();
    }

}
