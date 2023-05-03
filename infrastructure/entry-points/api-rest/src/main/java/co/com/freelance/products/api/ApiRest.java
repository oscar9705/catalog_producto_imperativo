package co.com.freelance.products.api;
import co.com.freelance.products.model.product.Product;
import co.com.freelance.products.usecase.crudproduct.CrudProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CrudProductUseCase crudProductUseCase;
    private final HttpServletRequest request;



    @GetMapping(path = "/product/{id}")
    public ResponseEntity<?> read(@PathVariable String id, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(crudProductUseCase.read(id));
    }

    @GetMapping(path = "/product")
    public List<Product> getAll() {
        return crudProductUseCase.getAll();
    }


    @PostMapping(path = "/product")
    public ResponseEntity<?>  create(@RequestBody Product product) {
        crudProductUseCase.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/product/{id}")
    public void update(@PathVariable String id, @RequestBody Product product) throws Exception {
        crudProductUseCase.update(id, product);
    }
}
