package br.ada.customer.crud.factory;

import br.ada.customer.crud.integration.database.MemoryDatabase;
import br.ada.customer.crud.integration.memoryrepository.ProductMemoryRepositoryImpl;
import br.ada.customer.crud.usecases.IProductUseCase;
import br.ada.customer.crud.usecases.impl.ProductUseCaseImpl;
import br.ada.customer.crud.usecases.repository.ProductRepository;

public class ProductFactory {

    public static IProductUseCase createUseCase() {
        return new ProductUseCaseImpl(
                createRepository()
        );
    }

    public static ProductRepository createRepository() {
        return new ProductMemoryRepositoryImpl(
                MemoryDatabase.getInstance()
        );
    }

}
