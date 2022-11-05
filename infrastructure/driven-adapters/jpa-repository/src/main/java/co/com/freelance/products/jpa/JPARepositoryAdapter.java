package co.com.freelance.products.jpa;

import co.com.freelance.products.jpa.entities.ProductEntity;
import co.com.freelance.products.jpa.helper.AdapterOperations;
import co.com.freelance.products.model.product.Product;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Product/* change for domain model */, ProductEntity/* change for adapter model */, String, JPARepository>
// implements ModelRepository from domain
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Product.class/* change for domain model */));
    }
}
