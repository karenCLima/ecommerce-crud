package br.ada.customer.crud.view.menu;

import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.factory.OrderFactory;
import br.ada.customer.crud.factory.ProductFactory;
import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.impl.ExitOptionView;
import br.ada.customer.crud.view.component.menu.impl.SubMenuView;
import br.ada.customer.crud.view.customer.CustomerMenuView;
import br.ada.customer.crud.view.order.OrderMenuView;
import br.ada.customer.crud.view.product.ProductMenuView;

import java.util.Arrays;

public class MainMenu implements View {

    @Override
    public void render() {
        SubMenuView subMenuView = new SubMenuView(Arrays.asList(
                new CustomerMenuView(
                        CustomerFactory.createUseCase(),
                        this
                ),
                new ProductMenuView(
                        ProductFactory.createUseCase(),
                        this
                ),
                new OrderMenuView(OrderFactory.createUseCase(), 
                		OrderFactory.orderAddItemUseCase(),
                		ProductFactory.createUseCase(),
                		OrderFactory.createRepository(),
                		OrderFactory.orderChangeAmountUseCase(),
                		OrderFactory.placeOrderUseCase(),
                		OrderFactory.payOrderUseCase(),
                		OrderFactory.shippingUseCase(),
                		ProductFactory.createRepository(),
                		this
                ),
                new ExitOptionView()
        ));
        subMenuView.render();
    }

}
