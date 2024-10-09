package ie.atu.week3cicd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product("Tv", "Made by Sony", 899, 100));
        products.add(new Product("Radio", "Made by Samsung", 99, 101));
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts()
    {
        return products;
    }
    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {
        products.add(product);
        return ResponseEntity.ok(products);
    }

    @PutMapping("?{id}")
    public ResponseEntity<List> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                products.set(i, product);
            }
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("deleteProducts/{id}")
    public ResponseEntity<List> removeProduct(@PathVariable int id)
    {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                products.remove(i);
            }
        }
        return ResponseEntity.ok(products);
    }
}
