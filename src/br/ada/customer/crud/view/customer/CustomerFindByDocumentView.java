package br.ada.customer.crud.view.customer;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.view.component.list.ListView;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;
import br.ada.customer.crud.view.customer.modelview.CustomerListModelView;

import java.util.List;

public class CustomerFindByDocumentView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "3";
    public static final Integer MENU_ORDER = 3;
    private ICustomerUseCase customerUseCase;

    public CustomerFindByDocumentView(ICustomerUseCase customerUseCase) {
        super(MENU_CODE, MENU_ORDER);
        this.customerUseCase = customerUseCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Consultar por documento");
    }

    @Override
    public void selected() {
        TextInputView txtDocument = new TextInputView("Informe o documento:");
        txtDocument.render();

        Customer customer = customerUseCase.findByDocument(txtDocument.value());
        ListView<Customer> listView = new ListView<>(List.of(customer), new CustomerListModelView());
        listView.render();
    }

}
