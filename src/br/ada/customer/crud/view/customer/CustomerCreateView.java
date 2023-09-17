package br.ada.customer.crud.view.customer;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.form.FormView;
import br.ada.customer.crud.view.component.form.IFormAction;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.customer.modelview.CustomerFormModelView;

public class CustomerCreateView extends AbstractMenuOptionView implements MenuOptionView, IFormAction<Customer> {

    public static final String MENU_CODE = "1";
    public static final Integer MENU_ORDER = 1;
    private ICustomerUseCase useCase;

    public CustomerCreateView(ICustomerUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Cadastrar");
    }

    @Override
    public void formExecute(Customer customer) {
        useCase.create(customer);
    }


    @Override
    public void selected() {
        CustomerFormModelView formModelView = new CustomerFormModelView();
        FormView<Customer> formView = new FormView<>(
                new Customer(),
                formModelView,
                this
        );
        formView.render();
    }

}
