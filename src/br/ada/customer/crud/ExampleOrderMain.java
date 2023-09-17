package br.ada.customer.crud;

import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.factory.OrderFactory;
import br.ada.customer.crud.factory.ProductFactory;
import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ExampleOrderMain {

    public static void main(String[] args) {
        IProductUseCase productUseCase = ProductFactory.createUseCase();
        ICustomerUseCase customerUseCase = CustomerFactory.createUseCase();
        ICreateOrderUseCase orderUseCase = OrderFactory.createUseCase();
        IOrderAddItemUseCase orderAddItemUseCase = OrderFactory.orderAddItemUseCase();
        IOrderChangeAmountUseCase orderChangeAmountUseCase = OrderFactory.orderChangeAmountUseCase();
        IOrderRemoveItemUseCase orderRemoveItemUseCase = OrderFactory.orderRemoveItemUseCase();
        IOrderPlaceUseCase orderPlaceUseCase = OrderFactory.placeOrderUseCase();
        IOrderPayUseCase orderPayUseCase = OrderFactory.payOrderUseCase();
        IOrderShippingUseCase orderShipping = OrderFactory.shippingUseCase();

        Customer customer = new Customer();
        customer.setName("William");
        List<String> email = Arrays.asList("william@gmail.com");
        customer.setEmail(email);
        customerUseCase.create(customer);

        Product productOne = new Product();
        productOne.setDescription("023");
        productUseCase.create(productOne);

        Product productTwo = new Product();
        productTwo.setDescription("1546");
        productUseCase.create(productTwo);

        Product productThree = new Product();
        productThree.setDescription("516");
        productUseCase.create(productThree);

        Order order = orderUseCase.create(customer);
        orderAddItemUseCase.addItem(order, productOne, BigDecimal.TEN, 1);
        orderAddItemUseCase.addItem(order, productTwo, BigDecimal.TEN, 2);
        orderChangeAmountUseCase.changeAmount(order, productTwo, 5);
        orderRemoveItemUseCase.removeItem(order, productOne);
        orderPlaceUseCase.placeOrder(order);
        orderPayUseCase.pay(order);
        orderShipping.shipping(order);
        
        
        List<OrderItem> orderItems = order.getItems();
        for(OrderItem orderItem : orderItems) {
        	System.out.println(orderItem.getId());
        }
    }

}
