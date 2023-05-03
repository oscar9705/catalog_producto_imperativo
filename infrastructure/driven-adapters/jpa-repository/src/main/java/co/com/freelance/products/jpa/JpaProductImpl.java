package co.com.freelance.products.jpa;

import co.com.freelance.products.model.product.Product;
import co.com.freelance.products.model.product.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaProductImpl implements ProductRepository {

    private final JPARepositoryAdapter jpaRepositoryAdapter;
    @Override
    public void create(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        jpaRepositoryAdapter.save(product);
    }

    @Override
    public Product read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public void update(String id, Product product) throws Exception {
        Product productDb = jpaRepositoryAdapter.findById(id);

        if(productDb == null) {
            throw new Exception(String.format("Producto no existe : %s", id));
        }

        product.setId(id);
        jpaRepositoryAdapter.save(product);
    }

    @Override
    public void delete(String id) {
        jpaRepositoryAdapter.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
