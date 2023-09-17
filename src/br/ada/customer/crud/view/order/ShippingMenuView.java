package br.ada.customer.crud.view.order;

import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.IOrderShippingUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.table.TableView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.order.modelview.OrderTableModelView;

public class ShippingMenuView extends AbstractMenuOptionView implements MenuOptionView {

	public static final String MENU_CODE = "6";
    public static final Integer MENU_ORDER = 6; 
    private IOrderShippingUseCase shippingUseCase;
    private OrderRepository orderRepository;
    
    public ShippingMenuView(IOrderShippingUseCase shippingUseCase, OrderRepository orderRepository) {
		super(MENU_CODE, MENU_ORDER);
		this.shippingUseCase = shippingUseCase;
		this.orderRepository = orderRepository;
	}

	@Override
	public void render() {
		System.out.println(MENU_CODE + " - Finalizar Pedido e enviar");
		
	}

	@Override
	public void selected() {
		List<Order> orders = orderRepository.listAll();
    	TableView tableView = new TableView(
              orders,
              new OrderTableModelView()
    	);
    	tableView.render();
    	
    	ObjectInputView <Long> txtId = new ObjectInputView<>("Informe o Id do Pedido: ", new LongTextConverter());
    	txtId.render();
    	Order order = orderRepository.findById(txtId.value());
    	
    	shippingUseCase.shipping(order);
		
	}
	
}
