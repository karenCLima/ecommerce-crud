package br.ada.customer.crud.view.order;

import br.ada.customer.crud.usecases.ICreateOrderUseCase;
import br.ada.customer.crud.usecases.IOrderAddItemUseCase;
import br.ada.customer.crud.usecases.IOrderChangeAmountUseCase;
import br.ada.customer.crud.usecases.IOrderPayUseCase;
import br.ada.customer.crud.usecases.IOrderPlaceUseCase;
import br.ada.customer.crud.usecases.IOrderShippingUseCase;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.usecases.repository.ProductRepository;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.menu.impl.GoBackOptionView;
import br.ada.customer.crud.view.component.menu.impl.SubMenuView;

import java.util.Arrays;

public class OrderMenuView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "3";
    public static final Integer MENU_ORDER = 3;
    
    private ICreateOrderUseCase createUseCase;
    private IOrderAddItemUseCase addItemUseCase;
    private IProductUseCase productUseCase;
    private OrderRepository orderRepository;
    private IOrderChangeAmountUseCase changeAmountUseCase;
    private IOrderPlaceUseCase placeUseCase;
    private IOrderPayUseCase payUseCase;
    private IOrderShippingUseCase shippingUseCase;
    private ProductRepository productRepository;
    private View comeFrom;

    public OrderMenuView(ICreateOrderUseCase createOrderUseCase,
    		IOrderAddItemUseCase addItemUseCase,
    		IProductUseCase productUseCase, 
    		OrderRepository orderRepository, 
    		IOrderChangeAmountUseCase changeAmountUseCase,
    		IOrderPlaceUseCase placeUseCase,
    		IOrderPayUseCase payUseCase,
    		IOrderShippingUseCase shippingUseCase,
    		ProductRepository productRepository,
    		View comeFrom) {
        super(MENU_CODE, MENU_ORDER);
        this.createUseCase = createOrderUseCase;
        this.addItemUseCase = addItemUseCase;
        this.productUseCase = productUseCase;
        this.orderRepository = orderRepository;
        this.changeAmountUseCase = changeAmountUseCase;
        this.placeUseCase =placeUseCase;
        this.payUseCase = payUseCase;
        this.shippingUseCase = shippingUseCase;
        this.productRepository = productRepository;
        this.comeFrom = comeFrom;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Order");
    }

    @Override
    public void selected() {
        SubMenuView subMenuView = new SubMenuView(
                Arrays.asList(
                        new CreateOrderMenuView(createUseCase),
                        new AddItemMenuView(addItemUseCase,productUseCase, orderRepository),
                        new ChangeAmountMenuView(changeAmountUseCase,orderRepository,productRepository),
                        new PlaceOrderMenuView(placeUseCase,orderRepository),
                        new PayMenuView(payUseCase,orderRepository),
                        new ShippingMenuView(shippingUseCase, orderRepository),
                        new OrderTableMenuView(orderRepository),
                        new GoBackOptionView(comeFrom)
                )
        );
        subMenuView.render();
    }

}
