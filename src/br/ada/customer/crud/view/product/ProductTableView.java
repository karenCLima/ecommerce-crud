package br.ada.customer.crud.view.product;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.table.TableView;
import br.ada.customer.crud.view.product.modelview.ProductTableModelView;

import java.util.List;

public class ProductTableView extends AbstractMenuOptionView implements MenuOptionView {


    public static final String MENU_CODE = "2";
    public static final Integer MENU_ORDER = 2;
    private IProductUseCase useCase;

    public ProductTableView(IProductUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Listar");
    }

    @Override
    public void selected() {
        List<Product> products = useCase.listAll();
        TableView tableView = new TableView(
                products,
                new ProductTableModelView()
        );
        tableView.render();
    }

}
