package com.example.practice.repository;

//import net.javaguides.springdatajpacourse.entity.Product;
import com.example.practice.entity.Product;
import com.example.practice.repoditory.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    // DI in test we can to use only Autowired
    @Autowired
    private ProductRepository productRepository;


    @Test
    void testSaveMethod() throws InterruptedException {
        Product product = getProduct1();

        // save product
        productRepository.save(product);
    }

    @Test
    void testUpdateMethod() throws InterruptedException {
        Product product = getProduct1();

        // save product
        Product savedProduct = productRepository.save(product);

        savedProduct.setName("product 1 updated");
        savedProduct.setDescription("product 1 desc updated");
        savedProduct.setPrice(new BigDecimal(300));

        // update product
        Product updatedProduct = productRepository.save(savedProduct);

        System.out.println(updatedProduct.getName());
        System.out.println(updatedProduct.getDescription());
        System.out.println(updatedProduct.getPrice());
    }

    @Test
    void testSaveAllMethod(){
        Product product = getProduct1();

        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 desc");
        product2.setPrice(new BigDecimal(200));
        product2.setSku("product 2 sku");
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        productRepository.saveAll(List.of(product, product2));
    }

    @Test
    void testFindByIdMethod(){
        Product product = getProduct1();

        // save product
        productRepository.save(product);

        // get product by id
        Product savedProduct = productRepository.findById(product.getId()).get();

        System.out.println(savedProduct.getName());
    }

    @Test
    void testFindAllMethod(){
        Product product = getProduct1();

        Product product2 = getProduct2();

        productRepository.saveAll(List.of(product, product2));

        productRepository.findAll().forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void testCountMethod(){
        Product product = getProduct1();

        Product product2 = getProduct2();

        productRepository.saveAll(List.of(product, product2));

        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void testDeleteByIdMethod(){
        Product product = getProduct1();

        productRepository.save(product);

        // delete product by id
        productRepository.deleteById(product.getId());
    }

    @Test
    void testDeleteMethod(){
        Product product = getProduct1();

        productRepository.save(product);

        // delete product by id
        productRepository.delete(product);
    }

    @Test
    void testDeleteAllMethod(){
        Product product = getProduct1();

        Product product2 = getProduct2();

        productRepository.saveAll(List.of(product, product2));

        productRepository.deleteAll();
    }

    private Product getProduct1(){
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 desc");
        product.setPrice(new BigDecimal(100));
        product.setSku("product 1 sku");
        product.setActive(true);
        product.setImageUrl("product1.png");
        return product;
    }

    private Product getProduct2(){
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 desc");
        product2.setPrice(new BigDecimal(200));
        product2.setSku("product 2 sku");
        product2.setActive(true);
        product2.setImageUrl("product2.png");
        return product2;
    }
}