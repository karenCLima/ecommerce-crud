package br.ada.customer.crud.view.product;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.form.FormView;
import br.ada.customer.crud.view.component.form.IFormAction;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.product.modelview.ProductFormModelView;

public class ProductCreateView extends AbstractMenuOptionView implements MenuOptionView, IFormAction<Product> {

    public static final String MENU_CODE = "1";
    public static final Integer MENU_ORDER = 1;
    private IProductUseCase useCase;

    public ProductCreateView(IProductUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Cadastrar");
    }

    @Override
    public void formExecute(Product product) {
        useCase.create(product);
    }

    @Override
    public void selected() {
        ProductFormModelView formModelView = new ProductFormModelView();
        FormView<Product> formView = new FormView<>(
                new Product(),
                formModelView,
                this
        );
        formView.render();
    }

}
