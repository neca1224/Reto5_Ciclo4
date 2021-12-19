package app.sa.reto5mintic.app.repository;


import app.sa.reto5mintic.app.model.Vegetarian;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import app.sa.reto5mintic.app.service.VegetarianCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class VegetarianRepository {
    @Autowired
    private VegetarianCrudRepository repository;

    public List<Vegetarian> getAll() {
        return repository.findAll();
    }

    public Optional<Vegetarian> getproduct(String reference) {
        return repository.findById(reference);
    }
    
    public Vegetarian create(Vegetarian clothe) {
        return repository.save(clothe);
    }

    public void update(Vegetarian clothe) {
        repository.save(clothe);
    }
    
    public void delete(Vegetarian clothe) {
        repository.delete(clothe);
    } 
    //Reto 5
    public List<Vegetarian> productByPrice(double precio){
        return repository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description){
        return repository.findByDescriptionLike(description);
    }
}
