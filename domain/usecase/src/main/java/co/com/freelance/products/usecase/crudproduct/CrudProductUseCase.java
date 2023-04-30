package co.com.freelance.products.usecase.crudproduct;

import co.com.freelance.products.model.exception.NotFoundException;
import co.com.freelance.products.model.product.Product;
import co.com.freelance.products.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CrudProductUseCase {
    private final ProductRepository productRepository;

    public void create(Product product) {
        productRepository.create(product);
    }

    public Product read(String id) {
        Product product = productRepository.read(id);
        if (product == null) {
            throw new NotFoundException("No se encontró el producto");
        }

        return productRepository.read(id);
    }

    public void update(String id, Product product) throws Exception {
        productRepository.update(id, product);
    }

    public void delete(String id) {
        productRepository.delete(id);
    }

    public List<Product> getAll() {
        return productRepository.getAlll();
    }
}
