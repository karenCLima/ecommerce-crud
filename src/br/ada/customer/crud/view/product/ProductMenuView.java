package br.ada.customer.crud.view.product;

import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.menu.impl.GoBackOptionView;
import br.ada.customer.crud.view.component.menu.impl.SubMenuView;

import java.util.Arrays;

public class ProductMenuView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "2";
    public static final Integer MENU_ORDER = 2;

    private IProductUseCase useCase;
    private View comeFrom;

    public ProductMenuView(IProductUseCase useCase, View comeFrom) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
        this.comeFrom = comeFrom;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Product");
    }

    @Override
    public void selected() {
        SubMenuView subMenuView = new SubMenuView(Arrays.asList(
                new ProductCreateView(useCase),
                new ProductTableView(useCase),
                new ProductFindByBarcodeView(useCase),
                new ProductFindByDescriptionView(useCase),
                new ProductUpdateView(useCase),
                new ProductDeleteView(useCase),
                new GoBackOptionView(comeFrom)
        ));
        subMenuView.render();
    }

}
