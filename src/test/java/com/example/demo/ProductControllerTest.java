package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private WebApplicationContext applicationContext;
    private MockMvc mvc;
    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void test() throws Exception{
        Product product = new Product();
        product.setName("Tablette");
        product.setPrice(22);
        mvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(product)))
                .andExpect(status().isOk());



        mvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());
    }

    private String toJson(Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }

    }


