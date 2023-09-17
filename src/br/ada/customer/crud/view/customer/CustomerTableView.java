package br.ada.customer.crud.view.customer;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.table.TableView;
import br.ada.customer.crud.view.customer.modelview.CustomerTableModelView;

import java.util.List;

public class CustomerTableView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "2";
    public static final Integer MENU_ORDER = 2;
    private ICustomerUseCase useCase;

    public CustomerTableView(ICustomerUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Listar");
    }


    @Override
    public void selected() {
        List<Customer> customers = useCase.list();
        TableView tableView = new TableView(
                customers,
                new CustomerTableModelView()
        );
        tableView.render();
    }

}
