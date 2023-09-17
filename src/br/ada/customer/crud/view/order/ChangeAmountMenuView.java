package br.ada.customer.crud.view.order;

import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderChangeAmountUseCase;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.usecases.repository.ProductRepository;
import br.ada.customer.crud.view.component.convert.impl.IntegerTextConverter;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.convert.impl.ProductTextConverter;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.table.TableView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.order.modelview.OrderItemTableModelView;
import br.ada.customer.crud.view.order.modelview.OrderTableModelView;

public class ChangeAmountMenuView extends AbstractMenuOptionView implements MenuOptionView {
	
	public static final String MENU_CODE = "3";
    public static final Integer MENU_ORDER = 3;
    private IOrderChangeAmountUseCase changeAmountUseCase;
    private OrderRepository repository;
    private ProductRepository productRepository;
	

	public ChangeAmountMenuView(IOrderChangeAmountUseCase changeAmountUseCase,OrderRepository repository, ProductRepository productRepository) {
		super(MENU_CODE, MENU_ORDER);
		this.changeAmountUseCase = changeAmountUseCase;
		this.repository = repository;
		this.productRepository = productRepository;
	}
	
	@Override
	public void render() {
		System.out.println(MENU_CODE + " - Mudar quantidade de um item do pedido");	
	}

	@Override
	public void selected() {
		List<Order> orders = repository.listAll();
    	TableView tableView = new TableView(
              orders,
              new OrderTableModelView()
    	);
    	tableView.render();
    	
    	ObjectInputView <Long> txtId = new ObjectInputView<>("Informe o Id do Pedido: ", new LongTextConverter());
    	txtId.render();
    	Order order = repository.findById(txtId.value());
    	
    	List<OrderItem> orderItems = order.getItems();
    	TableView tableViewOrderItem = new TableView(
                orderItems,
                new OrderItemTableModelView()
      	);
      	tableViewOrderItem.render();
      	
      	ObjectInputView <Long> txtProductId = new ObjectInputView<>("Informe o ID do Item: ", new LongTextConverter());
      	txtProductId.render();
      	
      	Product product = productRepository.findById(txtProductId.value());
    	
    	ObjectInputView <Integer> txtAmount = new ObjectInputView<>("Informe a nova quantidade: ", new IntegerTextConverter());
    	txtAmount.render();
    	
    	changeAmountUseCase.changeAmount(order, product,txtAmount.value());
    	
    	System.out.println("Quantidade alterada com sucesso!");
    	
    	List<OrderItem> orderItems2 = order.getItems();
    	TableView tableViewOrderItem2 = new TableView(
                orderItems,
                new OrderItemTableModelView()
      	);
      	tableViewOrderItem2.render();
		
    }
		

	

}
