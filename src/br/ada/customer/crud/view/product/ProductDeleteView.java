package br.ada.customer.crud.view.product;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.product.modelview.ProductListModelView;

import java.util.List;

public class ProductDeleteView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "6";
    public static final Integer MENU_ORDER = 6;
    private IProductUseCase useCase;

    public ProductDeleteView(IProductUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Excluir");
    }

    @Override
    public void selected() {
        List<Product> products = useCase.listAll();
        ListView<Product> listView = new ListView<>(products, new ProductListModelView());
        listView.render();

        ObjectInputView<Long> txtId = new ObjectInputView<>("Informe o id do produto: ", new LongTextConverter());
        txtId.render();
        useCase.delete(txtId.value());
    }

}
