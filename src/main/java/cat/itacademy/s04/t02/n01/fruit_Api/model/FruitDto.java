package cat.itacademy.s04.t02.n01.fruit_Api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FruitDto (

        Long id,

        @NotBlank(message = "Name can't be empty")
        String name,

        @NotNull(message = "Weight can't be null")
        @Positive(message = "Weight has to be positive")
        Double weightKg

){}
