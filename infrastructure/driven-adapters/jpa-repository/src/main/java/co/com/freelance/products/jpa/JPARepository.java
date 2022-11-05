package co.com.freelance.products.jpa;

import co.com.freelance.products.jpa.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<ProductEntity/* change for adapter model */, String>, QueryByExampleExecutor<ProductEntity/* change for adapter model */> {
}
