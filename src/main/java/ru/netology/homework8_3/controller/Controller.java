package ru.netology.homework8_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.homework8_3.repository.Repository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/fetch-product")
    public List<String> getProduct(@RequestParam("name") String name) {
        return repository.getProductName(name);
    }
}
