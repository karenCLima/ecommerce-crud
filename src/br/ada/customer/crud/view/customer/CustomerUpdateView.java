package br.ada.customer.crud.view.customer;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.form.FormView;
import br.ada.customer.crud.view.component.form.IFormAction;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.customer.modelview.CustomerFormModelView;
import br.ada.customer.crud.view.customer.modelview.CustomerListModelView;
import br.ada.customer.crud.view.customer.modelview.CustomerTableModelView;

public class CustomerUpdateView extends AbstractMenuOptionView implements MenuOptionView, IFormAction<Customer> {

    public static final String MENU_CODE = "4";
    public static final Integer MENU_ORDER = 4;
    private ICustomerUseCase useCase;

    public CustomerUpdateView(ICustomerUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Atualizar");
    }

    @Override
    public void formExecute(Customer customer) {
        useCase.update(customer);
    }

    @Override
    public void selected() {
        ListView<Customer> listView = new ListView<>(useCase.list(), new CustomerListModelView());
        listView.render();

        ObjectInputView<Long> txtId = new ObjectInputView<>("Informe o id do cliente: ", new LongTextConverter());
        txtId.render();

        Customer customer = new Customer();
        customer.setId(txtId.value());

        FormView<Customer> formView = new FormView<>(
                customer,
                new CustomerFormModelView(),
                this
        );
        formView.render();
    }

}
