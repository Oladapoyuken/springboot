package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


//This class consumes an API and implement the CRUD resource

@RestController
public class ConsumeWebServiceController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/product")
    public String getProductList(){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(header);

        return restTemplate.exchange("http://localhost:8080/product", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/product", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(product, header);

        return restTemplate.exchange("http://localhost:8080/product", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/product/{id}", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product, @PathVariable("id") String id){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(product, header);

        return restTemplate.exchange("http://localhost:8080/product/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/product/{id}", method = RequestMethod.DELETE)
    public String createProduct(@PathVariable("id") String id){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(header);

        return restTemplate.exchange("http://localhost:8080/product/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }


}
