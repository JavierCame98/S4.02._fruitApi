package cat.itacademy.s04.t02.n01.fruit_Api.controller;

import cat.itacademy.s04.t02.n01.fruit_Api.model.FruitDto;
import cat.itacademy.s04.t02.n01.fruit_Api.service.FruitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    public ResponseEntity<FruitDto> create (@Valid @RequestBody FruitDto fruitDto){
        FruitDto createdFruit = fruitService.createFruit(fruitDto);

        URI lcoation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFruit.id())
                .toUri();

        return ResponseEntity.created(lcoation).body(createdFruit);
    }

    @GetMapping
    public ResponseEntity<List<FruitDto>> getAll (){
        List<FruitDto> fruits = fruitService.getAll();
        return ResponseEntity.ok(fruits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FruitDto> getById (@PathVariable Long id){
        return ResponseEntity.ok(fruitService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FruitDto> update (@PathVariable Long id, @Valid @RequestBody FruitDto fruitDto){
        return ResponseEntity.ok(fruitService.update(id, fruitDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        fruitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
