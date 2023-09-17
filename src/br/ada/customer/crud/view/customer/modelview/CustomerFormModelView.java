package br.ada.customer.crud.view.customer.modelview;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.convert.impl.DateTextConverter;
import br.ada.customer.crud.view.component.form.IFormModelView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;

import java.time.LocalDate;
import java.util.Arrays;

public class CustomerFormModelView implements IFormModelView<Customer> {

    private TextInputView txtNome = new TextInputView("Informe o nome: ");
    private TextInputView txtDocument = new TextInputView(("Informe o documento: "));
    private TextInputView txtEmail = new TextInputView("Informe o email(separa com virgula): ");
    private TextInputView txtTelephone = new TextInputView("Informe o telefone(separe com virgula): ");
    private ObjectInputView<LocalDate> txtBirthDate = new ObjectInputView<>("Informe a data de nascimento(dd/mm/aaaa):", new DateTextConverter());

    @Override
    public View[] views() {
        return new View[]{
                txtNome,
                txtDocument,
                txtEmail,
                txtTelephone,
                txtBirthDate
        };
    }

    @Override
    public void applyUpdate(Customer customer) {
        customer.setName(txtNome.value());
        customer.setDocument(txtDocument.value());
        customer.setEmail(Arrays.asList(txtEmail.value().split(",")));
        customer.setTelephone(Arrays.asList(txtTelephone.value().split(",")));
        customer.setBirthDate(txtBirthDate.value());
    }

}
