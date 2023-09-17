package br.ada.customer.crud.factory;

import br.ada.customer.crud.integration.database.MemoryDatabase;
import br.ada.customer.crud.integration.email.CustomerEmailNotifierImpl;
import br.ada.customer.crud.integration.email.OrderPayEmailNotifier;
import br.ada.customer.crud.integration.email.OrderPlaceEmailNotifier;
import br.ada.customer.crud.integration.email.OrderShippingEmailNotifier;
import br.ada.customer.crud.integration.email.SendEmail;
import br.ada.customer.crud.integration.memoryrepository.OrderEntityMerge;
import br.ada.customer.crud.integration.memoryrepository.OrderMemoryRepositoryImpl;
import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.*;
import br.ada.customer.crud.usecases.impl.CreateOrderUseCaseImpl;
import br.ada.customer.crud.usecases.impl.OrderAddItemUseCaseImpl;
import br.ada.customer.crud.usecases.impl.OrderChangeAmountUseCaseImpl;
import br.ada.customer.crud.usecases.impl.OrderPayUseCaseImpl;
import br.ada.customer.crud.usecases.impl.OrderPlaceUseCaseImpl;
import br.ada.customer.crud.usecases.impl.OrderRemoveItemUseCaseImpl;
import br.ada.customer.crud.usecases.impl.OrderShippingUseCaseImpl;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderFactory {

    public static ICreateOrderUseCase createUseCase() {
        return new CreateOrderUseCaseImpl(
                createRepository(),
                CustomerFactory.createRepository()
        );
    }

    public static IOrderAddItemUseCase orderAddItemUseCase() {
        return new OrderAddItemUseCaseImpl(createRepository());
    }
    
    public static IOrderChangeAmountUseCase orderChangeAmountUseCase() {
        return new OrderChangeAmountUseCaseImpl(createRepository());
    }
    
    public static IOrderRemoveItemUseCase orderRemoveItemUseCase() {
        return new OrderRemoveItemUseCaseImpl(createRepository());
    }

    public static IOrderPlaceUseCase placeOrderUseCase() {
        return new OrderPlaceUseCaseImpl(createRepository(), createPlaceNotifier());
    }

    public static IOrderPayUseCase payOrderUseCase() {
        return new OrderPayUseCaseImpl(createRepository(), createPayNotifier());
    }

    public static IOrderShippingUseCase shippingUseCase() {
        return new OrderShippingUseCaseImpl(createRepository(), createShippingNotifier());
    }

    public static OrderRepository createRepository() {
        return new OrderMemoryRepositoryImpl(
                MemoryDatabase.getInstance(),
                new OrderEntityMerge(MemoryDatabase.getInstance())
        );
    }
    
    public static IOrderNotifierUseCase createShippingNotifier() {
        return new OrderShippingEmailNotifier(new SendEmail());
    }
    
    public static IOrderNotifierUseCase createPayNotifier() {
        return new OrderPayEmailNotifier(new SendEmail());
    }
    
    public static IOrderNotifierUseCase createPlaceNotifier() {
        return new OrderPlaceEmailNotifier(new SendEmail());
    }
}
