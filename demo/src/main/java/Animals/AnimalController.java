package Animals;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class AnimalController {

    private Map<Integer,Animal> animals=new HashMap<>();



    @RequestMapping(value = "/animals",method = RequestMethod.GET)
    public List<Animal> getAll(){
        return new ArrayList<>(animals.values());
    }


    @RequestMapping(value = "/animals/{id}",method = RequestMethod.GET)
    public Animal getById(@PathVariable int id){
        return animals.get(id);
    }

    @RequestMapping(value = "/animals",method = RequestMethod.POST)
    public void PostAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
    }

    @RequestMapping(value = "/animals/{id}", method = RequestMethod.PUT)
    public String putAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        Animal existingAnimal = animals.get(id);

        if (existingAnimal != null) {
            existingAnimal.setName(updatedAnimal.getName());
            return "Succesful";
        } else {
            return "Id not found";
        }
    }

    @RequestMapping(value = "/animals/{id}", method = RequestMethod.DELETE)
    public String deleteAnimal(@PathVariable int id) {
        Animal existingAnimal = animals.get(id);

        if (existingAnimal != null) {
            animals.remove(id);
            return "Başarıyla silindi.";
        } else {
            return "Id not found";
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(AnimalController.class, args);
    }


}
