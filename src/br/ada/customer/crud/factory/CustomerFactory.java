package br.ada.customer.crud.factory;

import br.ada.customer.crud.integration.database.MemoryDatabase;
import br.ada.customer.crud.integration.email.CustomerEmailNotifierImpl;
import br.ada.customer.crud.integration.email.SendEmail;
import br.ada.customer.crud.integration.memoryrepository.CustomerMemoryRepositoryImpl;
import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.usecases.INotifierUserCase;
import br.ada.customer.crud.usecases.impl.CustomerUseCaseImpl;
import br.ada.customer.crud.usecases.repository.CustomerRepository;

public class CustomerFactory {

    public static ICustomerUseCase createUseCase() {
        return new CustomerUseCaseImpl(
                createRepository(),
                createNotifier()
        );
    }

    public static CustomerRepository createRepository() {
        return new CustomerMemoryRepositoryImpl(MemoryDatabase.getInstance());
    }

    public static INotifierUserCase<Customer> createNotifier() {
        return new CustomerEmailNotifierImpl(new SendEmail());
    }

}
