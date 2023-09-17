package br.ada.customer.crud.view.order;

import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.table.TableView;
import br.ada.customer.crud.view.order.modelview.OrderTableModelView;

public class OrderTableMenuView extends AbstractMenuOptionView implements MenuOptionView{
	
	public static final String MENU_CODE = "7";
    public static final Integer MENU_ORDER = 7;
    private OrderRepository orderRepository;
    
    public OrderTableMenuView(OrderRepository orderRepository) {
		super(MENU_CODE, MENU_ORDER);
		this.orderRepository = orderRepository;
	}
    
	@Override
	public void render() {
		System.out.println(MENU_CODE + " - Listar Pedidos");
		
	}
	@Override
	public void selected() {
		List<Order> orders = orderRepository.listAll();
    	TableView tableView = new TableView(
              orders,
              new OrderTableModelView()
    	);
    	tableView.render();
		
	}

}
