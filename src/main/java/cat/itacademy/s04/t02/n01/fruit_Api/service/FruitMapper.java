package cat.itacademy.s04.t02.n01.fruit_Api.service;

import cat.itacademy.s04.t02.n01.fruit_Api.model.Fruit;
import cat.itacademy.s04.t02.n01.fruit_Api.model.FruitDto;

public class FruitMapper {

    public static Fruit toEntity (FruitDto fruitDto){
        if(fruitDto == null) return null;

        return Fruit.builder()
                .name(fruitDto.name())
                .weightKg(fruitDto.weightKg())
                .build();
    }

    public static FruitDto toDto (Fruit fruit){
        if(fruit == null) return null;

        return new FruitDto(fruit.getId(), fruit.getName(), fruit.getWeightKg());
    }
}
