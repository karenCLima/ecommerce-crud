package br.ada.customer.crud.view.order;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.ICreateOrderUseCase;
import br.ada.customer.crud.view.component.form.FormView;
import br.ada.customer.crud.view.component.form.IFormAction;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.order.modelview.OrderFormModelView;

public class CreateOrderMenuView extends AbstractMenuOptionView implements MenuOptionView, IFormAction<Order> {

    public static final String MENU_CODE = "1";
    public static final Integer MENU_ORDER = 1;
    private ICreateOrderUseCase createOrderUseCase;

    public CreateOrderMenuView(ICreateOrderUseCase createOrderUseCase) {
        super(MENU_CODE, MENU_ORDER);
        this.createOrderUseCase = createOrderUseCase;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Criar um novo pedido");
    }
    
    public void formExecute(Order order) {
        createOrderUseCase.create(order.getCustomer());
    }

    @Override
    public void selected() {
    	
        
    	OrderFormModelView formModelView = new OrderFormModelView();
        FormView<Order> formView = new FormView<>(new Order(),formModelView, this);
        formView.render();
        System.out.println("Pedido criado!");
    }

}
