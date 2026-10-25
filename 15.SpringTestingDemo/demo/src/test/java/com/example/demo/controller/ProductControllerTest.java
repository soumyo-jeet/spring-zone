package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    public void getProductTest () throws Exception {
        // arrange
        Product product =
                new Product("Laptop", 50000, 10);
        product.setId(1L);

        when(productService.getProductById(1L))
                .thenReturn(product);

        //Act and assertion
        mockMvc.perform(get("/api/product/1")
                        .accept(String.valueOf(MediaType.APPLICATION_JSON))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(
                        String.valueOf(MediaType.APPLICATION_JSON)
                ))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(50000))
                .andExpect(jsonPath("$.stock").value(10));

        verify(productService).getProductById(1L);
    }
}
