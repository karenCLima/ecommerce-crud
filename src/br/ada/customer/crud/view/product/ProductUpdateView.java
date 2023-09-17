package br.ada.customer.crud.view.product;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.form.FormView;
import br.ada.customer.crud.view.component.form.IFormAction;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.product.modelview.ProductFormModelView;
import br.ada.customer.crud.view.product.modelview.ProductListModelView;

public class ProductUpdateView extends AbstractMenuOptionView implements MenuOptionView, IFormAction<Product> {


    public static final String MENU_CODE = "5";
    public static final Integer MENU_ORDER = 5;
    private IProductUseCase useCase;

    public ProductUpdateView(IProductUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Atualizar");
    }

    @Override
    public void formExecute(Product product) {
        useCase.update(product);
    }

    @Override
    public void selected() {
        ListView<Product> listView = new ListView<>(useCase.listAll(), new ProductListModelView());
        listView.render();

        ObjectInputView<Long> txtId = new ObjectInputView<>("Informe o id do produto:", new LongTextConverter());
        txtId.render();

        Product product = new Product();
        product.setId(txtId.value());
        FormView<Product> formView = new FormView<>(
                product,
                new ProductFormModelView(),
                this
        );
        formView.render();
    }

}
