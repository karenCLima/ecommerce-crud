package br.ada.customer.crud.view.customer;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.customer.modelview.CustomerListModelView;

import java.util.List;

public class CustomerDeleteView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "5";
    public static final Integer MENU_ORDER = 5;
    private ICustomerUseCase useCase;

    public CustomerDeleteView(ICustomerUseCase useCase) {
        super(MENU_CODE, MENU_ORDER);
        this.useCase = useCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Excluir");
    }

    @Override
    public void selected() {
        List<Customer> customers = useCase.list();
        ListView<Customer> listView = new ListView<>(customers, new CustomerListModelView());
        listView.render();

        ObjectInputView<Long> txtId = new ObjectInputView<>("Informe o id do cliente:", new LongTextConverter());
        txtId.render();
        useCase.delete(txtId.value());
    }

}
