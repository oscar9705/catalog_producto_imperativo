package co.com.freelance.products.api;
import co.com.freelance.products.model.product.Product;
import co.com.freelance.products.usecase.crudproduct.CrudProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;
    private final CrudProductUseCase crudProductUseCase;


    @GetMapping(path = "/product/{id}")
    public Product read(@PathVariable String id) {
        return crudProductUseCase.read(id);
    }

    @GetMapping(path = "/product")
    public List<Product> getAll() {
        return crudProductUseCase.getAll();
    }


    @PostMapping(path = "/product")
    public void create(@RequestBody Product product) {
        crudProductUseCase.create(product);
    }

    @PutMapping(path = "/product/{id}")
    public void update(@PathVariable String id, @RequestBody Product product) throws Exception {
        crudProductUseCase.update(id, product);
    }
}
