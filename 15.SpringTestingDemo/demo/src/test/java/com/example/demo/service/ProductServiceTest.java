package com.example.demo.service;


import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    public void getProductByIdTest() {
        // arrange
        Product product = new Product("Mixer", 145.32, 12);
        product.setId(1L);
        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        // act
        Product actualProduct = productService.getProductById(1L);

        // assert
        assert(actualProduct.getName().equals("Mixer"));
        assert(actualProduct.getPrice() == 145.32);
        assert(actualProduct.getStock() == 12);
    }


    @Test
    public void saveProductTest() {
        // arrange
        Product product = new Product("Mixer", 145.32, 12);
        Product savedProduct = new Product("Mixer", 145.32, 12);
        savedProduct.setId(1L);

        when(productRepository.existsByName("Mixer")).thenReturn(false);
        when(productRepository.save(product)).thenReturn(savedProduct);

        // act
        Product result = productService.createProduct(product);

        // assert
        assertEquals(1L, result.getId());
        assertEquals("Mixer", result.getName());

        verify(productRepository)
                .existsByName("Mixer");

        verify(productRepository)
                .save(product);
    }


    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        //Arrange
        when(productRepository.findById(99L))
                .thenReturn(Optional.empty());

        //Act
        RuntimeException exception =
                assertThrows(RuntimeException.class, () ->
                        productService.getProductById(99L)
                );


        // assertion
        assertEquals("Product not found: 99",
                exception.getMessage());

        verify(productRepository).findById(99L);
    }

}
