package br.ada.customer.crud.view.order;

import java.math.BigDecimal;
import java.util.List;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderAddItemUseCase;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.view.component.convert.impl.IntegerTextConverter;
import br.ada.customer.crud.view.component.convert.impl.LongTextConverter;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.table.TableView;
import br.ada.customer.crud.view.component.text.impl.ObjectInputView;
import br.ada.customer.crud.view.component.text.impl.TextInputView;
import br.ada.customer.crud.view.order.modelview.OrderTableModelView;
import br.ada.customer.crud.view.product.modelview.ProductTableModelView;

public class AddItemMenuView extends AbstractMenuOptionView implements MenuOptionView {
	
	public static final String MENU_CODE = "2";
    public static final Integer MENU_ORDER = 2;
    private IOrderAddItemUseCase addItemUseCase;
    private IProductUseCase productUseCase;
    private OrderRepository repository;

    public AddItemMenuView(IOrderAddItemUseCase addItemUseCase,IProductUseCase productUseCase, OrderRepository repository) {
        super(MENU_CODE, MENU_ORDER);
        this.addItemUseCase = addItemUseCase;
        this.productUseCase = productUseCase;
        this.repository = repository;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Adicionar item");
    }
    
    @Override
    public void selected() {
    	List<Order> orders = repository.listAll();
    	TableView tableView = new TableView(
              orders,
              new OrderTableModelView()
    	);
    	tableView.render();
    	
    	ObjectInputView <Long> txtId = new ObjectInputView<>("Informe o ID do Cliente: ", new LongTextConverter());
    	txtId.render();
    	Order order = repository.findById(txtId.value());
    	
    	List<Product> products = productUseCase.listAll();
        TableView tableViewProduct = new TableView(
                products,
                new ProductTableModelView()
        );
        tableViewProduct.render();
        
        TextInputView txtBarCode = new TextInputView("Informe o CODIGO do produto: ");
        txtBarCode.render();
    	ObjectInputView <Integer> txtAmount = new ObjectInputView<>("Informe a quantidade: ", new IntegerTextConverter());
    	txtAmount.render();
    	Product product = productUseCase.findByBarcode(txtBarCode.value());
    	BigDecimal price = product.getPrice();
//
    	addItemUseCase.addItem(order, product, price, txtAmount.value());
    	System.out.println("Item adicionado!");
    }

}
