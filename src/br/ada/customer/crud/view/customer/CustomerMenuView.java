package br.ada.customer.crud.view.customer;

import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.menu.impl.GoBackOptionView;
import br.ada.customer.crud.view.component.menu.impl.SubMenuView;

import java.util.Arrays;

public class CustomerMenuView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "1";
    public static final Integer MENU_ORDER = 1;

    private ICustomerUseCase useCase;
    private View comeFrom;

    public CustomerMenuView(ICustomerUseCase useCase, View comeFrom) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
        this.comeFrom = comeFrom;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Customer");
    }


    @Override
    public void selected() {
        SubMenuView subMenuView = new SubMenuView(
                Arrays.asList(
                        new CustomerCreateView(useCase),
                        new CustomerTableView(useCase),
                        new CustomerFindByDocumentView(useCase),
                        new CustomerUpdateView(useCase),
                        new CustomerDeleteView(useCase),
                        new GoBackOptionView(comeFrom)
                ));
        subMenuView.render();
    }

}
