package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts(){
        return products;
    }

    public ProductService(){
        products.add(new DigitalProduct(nextId++,"Clean Code (E- Book)",
                29.99, "/downloads/clean-code.pdf",4.2));
        products.add(new PhysicalProduct(nextId++,"White Mouse",
                204.99, 2.7,"5cm x 3cm x 1.9cm"));

    }

    public Product addProduct(Product product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream()
                .filter(p->p.getId()
                .equals(id))
                .findFirst();
    }
    public void deleteProduct(Long id){
        products.removeIf(p->p.getId().equals(id));
    }
    public List<Product> findByName(String name){
        return products.
                stream().
                filter(p->
                        p.getName()
                        .contains(name))
                .toList();
    }
}
