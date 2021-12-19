/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.sa.reto5mintic.app.controller;

import app.sa.reto5mintic.app.model.Vegetarian;
import app.sa.reto5mintic.app.service.VegetarianService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */

@RestController
@RequestMapping("/api/vegetarian")
@CrossOrigin("*")
public class VegetarianController {
     @Autowired
    private VegetarianService accessoryService;

    @GetMapping("/all")
    public List<Vegetarian> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Vegetarian> getProduct(@PathVariable("reference") String reference) {
        return accessoryService.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian create(@RequestBody Vegetarian gadget) {
        return accessoryService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian update(@RequestBody Vegetarian gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Vegetarian> productByPrice(@PathVariable("price") double precio) {
        return accessoryService.productByPrice(precio);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Vegetarian> findByDescriptionLike(@PathVariable("description") String description) {
        return accessoryService.findByDescriptionLike(description);
    }
}
